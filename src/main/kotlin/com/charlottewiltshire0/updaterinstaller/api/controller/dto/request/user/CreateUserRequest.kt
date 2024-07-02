package com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateUserRequest(
    @JsonProperty("username")
    val username: String,

    @JsonProperty("password")
    var password: String
)
