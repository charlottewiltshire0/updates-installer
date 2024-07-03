package com.charlottewiltshire0.updaterinstaller.api.dto.response.role

import com.fasterxml.jackson.annotation.JsonProperty

data class RoleResponse(
    @JsonProperty("id")
    val roleId: Long,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("description")
    val description: String,
)
