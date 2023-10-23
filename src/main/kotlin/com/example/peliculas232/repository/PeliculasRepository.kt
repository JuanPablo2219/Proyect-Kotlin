package com.example.peliculas232.repository

import com.example.peliculas232.model.Pelicula
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeliculasRepository : JpaRepository<Pelicula, Long?> {

    fun findById (id: Long?): Pelicula?
}