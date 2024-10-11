package com.example.archiunitdemo.arch

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


class NamingConventionTest {

    @Test
    fun shouldBePrefixInService() {
        val jc = ClassFileImporter().importPackages("com.example.archiunitdemo")
        val arch = classes()
                .that().resideInAPackage("com.example.archiunitdemo.service.impl..")
                .and().areAnnotatedWith(Service::class.java)
                .should().haveSimpleNameContaining("Service")
        arch.check(jc)
    }

    @Test
    fun shouldBePrefixInRepository() {
        val jc = ClassFileImporter().importPackages("com.example.archiunitdemo..")
        val arch = classes().that().areInterfaces()
                .and().resideInAPackage("com.example.archiunitdemo.repository..")
                .and().areAnnotatedWith(Repository::class.java)
                .should().haveSimpleNameContaining("Repository");
        arch.check(jc)
    }
}