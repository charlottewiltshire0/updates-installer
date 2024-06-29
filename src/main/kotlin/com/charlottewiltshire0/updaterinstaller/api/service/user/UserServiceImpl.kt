package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.RequestCreateUserDTO
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.ResponceCreateUserDTO
import com.charlottewiltshire0.updaterinstaller.store.entities.User
import com.charlottewiltshire0.updaterinstaller.store.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
): UserService {
    override fun createUser(requestCreateUserDTO: RequestCreateUserDTO): ResponceCreateUserDTO {
        requestCreateUserDTO.password = bCryptPasswordEncoder.encode(requestCreateUserDTO.password)

        val user = User(username = requestCreateUserDTO.username, password = requestCreateUserDTO.password)
        userRepository.save(user)
        return ResponceCreateUserDTO(username = user.username)
    }
}