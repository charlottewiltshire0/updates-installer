package com.charlottewiltshire0.updaterinstaller.api.dto.request.role

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateRoleRequest(
    @JsonProperty("name")
    val name: String,

    @JsonProperty("description")
    var description: String
)