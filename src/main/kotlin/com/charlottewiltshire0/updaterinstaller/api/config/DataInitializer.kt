package com.charlottewiltshire0.updaterinstaller.api.config

import com.charlottewiltshire0.updaterinstaller.store.entities.Role
import com.charlottewiltshire0.updaterinstaller.store.repositories.RoleRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DataInitializer(
    private val roleRepository: RoleRepository,
) {
    @Bean
    fun initData() = CommandLineRunner {
        val superAdminRole = roleRepository.save(Role(name = "ROLE_SUPERADMIN", description = "Superadmin with highest access level"))
        val adminRole = roleRepository.save(Role(name = "ROLE_ADMIN", description = "Administrator with full access"))
        val testerRole = roleRepository.save(Role(name = "ROLE_TESTER", description = "Tester with access to testing tools"))
        val userRole = roleRepository.save(Role(name = "ROLE_USER", description = "Standard user with limited access"))
    }
}