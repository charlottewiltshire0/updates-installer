package com.charlottewiltshire0.updaterinstaller.api.service.role

import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.CreateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.UpdateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.response.role.RoleResponse
import com.charlottewiltshire0.updaterinstaller.api.exception.role.RoleAlreadyExistsException
import com.charlottewiltshire0.updaterinstaller.api.exception.role.RoleCreationException
import com.charlottewiltshire0.updaterinstaller.api.exception.role.RoleNotFoundException
import com.charlottewiltshire0.updaterinstaller.store.entities.Role
import com.charlottewiltshire0.updaterinstaller.store.repositories.RoleRepository
import jakarta.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(
    private val roleRepository: RoleRepository
) : RoleService {
    override fun createRole(createRoleRequest: CreateRoleRequest): RoleResponse {
        validateCreateRoleRequest(createRoleRequest)

        val existingRole = roleRepository.findByName(createRoleRequest.name)
        if (existingRole.isPresent) {
            throw RoleAlreadyExistsException("Role with name ${createRoleRequest.name} already exists")
        }

        val newRole = Role(name = createRoleRequest.name, description = createRoleRequest.description)
        try {
            roleRepository.save(newRole)
        } catch (e: DataIntegrityViolationException) {
            throw RoleCreationException("Failed to create role due to data integrity violation", e)
        }

        return RoleResponse(roleId = newRole.id, name = newRole.name, description = newRole.description)
    }

    override fun getRoleById(id: Long): RoleResponse {
        val role = roleRepository.findById(id).orElseThrow { RoleNotFoundException("Role with id $id not found") }
        return RoleResponse(roleId = role.id, name = role.name, description = role.description)
    }

    @Transactional
    override fun deleteRoleById(id: Long): String {
        val role = roleRepository.findById(id).orElseThrow { RoleNotFoundException("Role with id $id not found") }
        roleRepository.delete(role)
        return "Role successfully deleted."
    }

    @Transactional
    override fun updateRoleById(id: Long, updateRoleRequest: UpdateRoleRequest): RoleResponse {
        val role = roleRepository.findById(id).orElseThrow { RoleNotFoundException("Role with id $id not found") }

        updateRoleRequest.name?.let { role.name = it }
        updateRoleRequest.description?.let { role.description = it }

        roleRepository.save(role)

        return RoleResponse(roleId = role.id, name = role.name, description = role.description)
    }

    private fun validateCreateRoleRequest(createRoleRequest: CreateRoleRequest) {
        if (createRoleRequest.name.isBlank()) {
            throw IllegalArgumentException("Role name cannot be blank")
        }
        if (createRoleRequest.description.isBlank()) {
            throw IllegalArgumentException("Role description cannot be blank")
        }
    }
}