package com.charlottewiltshire0.updaterinstaller.store.entities

import com.charlottewiltshire0.updaterinstaller.api.utils.UserIdGenerator
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

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
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "roles_id")]
    )
    val roles: Set<Roles> = mutableSetOf()
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles.flatMap { role ->
            role.privileges.map { privilege -> SimpleGrantedAuthority(privilege.name) }
        }.toMutableList()
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}