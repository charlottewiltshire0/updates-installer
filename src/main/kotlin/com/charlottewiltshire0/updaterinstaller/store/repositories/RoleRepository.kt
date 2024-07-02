package com.charlottewiltshire0.updaterinstaller.store.repositories

import com.charlottewiltshire0.updaterinstaller.store.entities.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Optional<Role>
}