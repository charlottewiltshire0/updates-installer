package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.RequestCreateUserDTO
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.ResponceCreateUserDTO

interface UserService {

    fun createUser(requestCreateUserDTO: RequestCreateUserDTO): ResponceCreateUserDTO
}