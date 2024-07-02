package com.charlottewiltshire0.updaterinstaller.store.entities

import com.charlottewiltshire0.updaterinstaller.api.utils.UserIdGenerator
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User (
    @Id
    val id: Long = UserIdGenerator.generateUserId().toLong(),

    @get:JvmName("username")
    @Column(unique = true, nullable = false)
    var username: String,

    @get:JvmName("password")
    @Column(nullable = false)
    var password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role> = mutableSetOf(),

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
