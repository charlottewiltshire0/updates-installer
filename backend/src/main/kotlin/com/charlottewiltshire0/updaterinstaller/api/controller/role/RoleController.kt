package com.charlottewiltshire0.updaterinstaller.api.controller.role

import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.CreateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.request.role.UpdateRoleRequest
import com.charlottewiltshire0.updaterinstaller.api.dto.response.role.RoleResponse
import com.charlottewiltshire0.updaterinstaller.api.service.role.RoleService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin("*")
class RoleController(
    private val roleService: RoleService
) {

    @PostMapping
    fun createRole(@RequestBody createRoleRequest: CreateRoleRequest): ResponseEntity<RoleResponse> {
        val roleResponse = roleService.createRole(createRoleRequest)
        return ResponseEntity(roleResponse, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getRoleById(@PathVariable id: Long): ResponseEntity<RoleResponse> {
        val roleResponse = roleService.getRoleById(id)
        return ResponseEntity(roleResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteRoleById(@PathVariable id: Long): ResponseEntity<String> {
        val message = roleService.deleteRoleById(id)
        return ResponseEntity(message, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateRoleById(@PathVariable id: Long, @RequestBody updateRoleRequest: UpdateRoleRequest): ResponseEntity<RoleResponse> {
        val roleResponse = roleService.updateRoleById(id, updateRoleRequest)
        return ResponseEntity(roleResponse, HttpStatus.OK)
    }
}