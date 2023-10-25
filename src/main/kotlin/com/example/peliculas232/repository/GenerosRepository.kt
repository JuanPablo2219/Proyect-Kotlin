package com.example.peliculas232.repository

import com.example.peliculas232.model.Genero
import com.example.peliculas232.model.Pelicula
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenerosRepository : JpaRepository<Genero, Long?> {

    fun findById (id: Long?): Genero?
}