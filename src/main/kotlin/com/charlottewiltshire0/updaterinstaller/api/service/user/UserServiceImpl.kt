package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.UserResponse
import com.charlottewiltshire0.updaterinstaller.api.exception.user.UserNotFoundException
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
    override fun createUser(createUserRequest: CreateUserRequest): UserResponse {
        createUserRequest.password = bCryptPasswordEncoder.encode(createUserRequest.password)

        val user = User(username = createUserRequest.username, password = createUserRequest.password)
        userRepository.save(user)

        return UserResponse(
            userId = user.id,
            username = user.username,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

    override fun getUserById(id: Long): UserResponse {
        val foundUser = userRepository.findById(id).orElseThrow {
            throw UserNotFoundException("User with id $id not found")
        }
        return UserResponse(
            userId = foundUser.id,
            username = foundUser.username,
            createdAt = foundUser.createdAt,
            updatedAt = foundUser.updatedAt
        )
    }

    override fun deleteUserById(id: Long): String {
        val foundUser = userRepository.deleteById(id)
        return "User successfully deleted."
    }

}