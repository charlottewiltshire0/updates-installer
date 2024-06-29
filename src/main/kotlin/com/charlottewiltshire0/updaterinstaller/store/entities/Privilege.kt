package com.charlottewiltshire0.updaterinstaller.store.entities

import jakarta.persistence.*

@Entity
@Table(name = "privileges")
class Privilege(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val name: String
)