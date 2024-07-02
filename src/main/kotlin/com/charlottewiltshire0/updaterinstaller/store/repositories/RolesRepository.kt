package com.charlottewiltshire0.updaterinstaller.store.repositories

import com.charlottewiltshire0.updaterinstaller.store.entities.Roles
import org.springframework.data.jpa.repository.JpaRepository

interface RolesRepository : JpaRepository<Roles, Long>