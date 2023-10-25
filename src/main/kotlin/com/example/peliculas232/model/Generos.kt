package com.example.peliculas232.model

import jakarta.persistence.*

@Entity
@Table(name = "generos")
class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    var nombre: String? = null

    var ciudad: String? = null
}