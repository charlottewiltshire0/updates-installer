package com.charlottewiltshire0.updaterinstaller.store.repositories

import com.charlottewiltshire0.updaterinstaller.store.entities.User
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@Repository
interface UserRepository : JpaRepository<User, Long> {
}