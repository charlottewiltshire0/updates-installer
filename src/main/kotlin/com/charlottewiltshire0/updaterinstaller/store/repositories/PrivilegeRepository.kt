package com.charlottewiltshire0.updaterinstaller.store.repositories

import com.charlottewiltshire0.updaterinstaller.store.entities.Privilege
import org.springframework.data.jpa.repository.JpaRepository

interface PrivilegeRepository : JpaRepository<Privilege, Long>