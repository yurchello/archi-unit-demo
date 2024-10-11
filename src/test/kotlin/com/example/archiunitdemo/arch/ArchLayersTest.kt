package com.example.archiunitdemo.arch

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import org.junit.jupiter.api.Test


class ArchLayersTest {

    @Test
    fun shouldCheckLayers() {
        val jc = ClassFileImporter().importPackages("com.example.archiunitdemo")
        val arch = layeredArchitecture() // Define layers
                .consideringAllDependencies()
                .layer("Controllers").definedBy("com.example.archiunitdemo.controller..")
                .layer("Service").definedBy("com.example.archiunitdemo.service..")
                .layer("Persistence").definedBy("com.example.archiunitdemo.repository..") // Add constraints

                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controllers", "Service")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service")
        arch.check(jc)
    }
}