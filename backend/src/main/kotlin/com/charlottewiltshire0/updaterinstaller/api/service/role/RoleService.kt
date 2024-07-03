package com.charlottewiltshire0.updaterinstaller.api.service.role

import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.CreateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.UpdateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.response.role.RoleResponse

interface RoleService {

    fun createRole(createRoleRequest: CreateRoleRequest): RoleResponse

    fun getRoleById(id: Long): RoleResponse

    fun deleteRoleById(id: Long): String

    fun updateRoleById(id: Long, updateRoleRequest: UpdateRoleRequest): RoleResponse

    // TODO: fun getUsersByRole

    // TODO: fun assignRole
}