package com.charlottewiltshire0.updaterinstaller.store.entities

import jakarta.persistence.*

@Entity
@Table(name = "roles")
class Roles (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val name: String,

    @Column(nullable = true)
    val description: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privileges",
        joinColumns = [JoinColumn(name = "roles_id")],
        inverseJoinColumns = [JoinColumn(name = "privileges_id")]
    )
    val privileges: Set<Privilege> = mutableSetOf()
)