package com.charlottewiltshire0.updaterinstaller.store.repositories

import com.charlottewiltshire0.updaterinstaller.store.entities.Privileges
import org.springframework.data.jpa.repository.JpaRepository

interface PrivilegesRepository : JpaRepository<Privileges, Long>