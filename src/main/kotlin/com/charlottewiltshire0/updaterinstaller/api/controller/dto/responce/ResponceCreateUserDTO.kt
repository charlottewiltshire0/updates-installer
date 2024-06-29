package com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponceCreateUserDTO(
    @JsonProperty("username")
    val username: String,
)
