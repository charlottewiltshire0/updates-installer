package com.charlottewiltshire0.updaterinstaller.api.service.user

import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.CreateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.request.user.UpdateUserRequest
import com.charlottewiltshire0.updaterinstaller.api.controller.dto.responce.user.UserResponse
import com.charlottewiltshire0.updaterinstaller.api.exception.user.UserNotFoundException
import com.charlottewiltshire0.updaterinstaller.store.entities.User
import com.charlottewiltshire0.updaterinstaller.store.repositories.UserRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
): UserService {
    override fun createUser(createUserRequest: CreateUserRequest): UserResponse {
        createUserRequest.password = passwordEncoder.encode(createUserRequest.password)

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
        return try {
            userRepository.deleteById(id)
            "User with id $id deleted successfully."
        } catch (ex: EntityNotFoundException) {
            "User with id $id not found."
        }
    }

    override fun updateUser(id: Long, updateUserRequest: UpdateUserRequest): UserResponse {
        val foundUser = userRepository.findById(id).orElseThrow {
            throw UserNotFoundException("User with id $id not found")
        }

        foundUser.username = updateUserRequest.username ?: foundUser.username
        foundUser.password = updateUserRequest.password?.let { bCryptPasswordEncoder.encode(it) } ?: foundUser.password

        val savedUser = userRepository.save(foundUser)
        return UserResponse(
            userId = savedUser.id,
            username = savedUser.username,
            createdAt = savedUser.createdAt,
            updatedAt = savedUser.updatedAt
        )
    }
}