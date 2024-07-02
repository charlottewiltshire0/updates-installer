package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.CreateUserResponse
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
    override fun createUser(createUserRequest: CreateUserRequest): CreateUserResponse {
        createUserRequest.password = bCryptPasswordEncoder.encode(createUserRequest.password)

        val user = User(username = createUserRequest.username, password = createUserRequest.password)
        userRepository.save(user)
        return CreateUserResponse(userId = user.id, username = user.username, createdAt = user.createdAt, updatedAt = user.updatedAt)
    }
}