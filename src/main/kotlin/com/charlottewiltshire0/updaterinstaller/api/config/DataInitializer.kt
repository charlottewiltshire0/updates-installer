package com.charlottewiltshire0.updaterinstaller.api.config

import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.CreateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.service.role.RoleService
import com.charlottewiltshire0.updaterinstaller.store.entities.Role
import com.charlottewiltshire0.updaterinstaller.store.repositories.RoleRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.DataIntegrityViolationException


@Configuration
class DataInitializer(
    private val roleRepository: RoleRepository,
) {
    @Bean
    fun initData() = CommandLineRunner {
        val rolesToInsert = listOf(
            Role(name = "ROLE_SUPERADMIN", description = "Superadmin with highest access level"),
            Role(name = "ROLE_ADMIN", description = "Administrator with full access"),
            Role(name = "ROLE_TESTER", description = "Tester with access to testing tools"),
            Role(name = "ROLE_USER", description = "Standard user with limited access")
        )

        rolesToInsert.forEach { role ->
            try {
                if (roleRepository.findByName(role.name) == null) {
                    roleRepository.save(role)
                }
            } catch (e: DataIntegrityViolationException) {
                println("Role with name ${role.name} already exists.")
            }
        }
    }
}