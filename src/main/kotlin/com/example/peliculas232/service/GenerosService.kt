package com.example.peliculas232.service

import com.example.peliculas232.model.Genero
import com.example.peliculas232.repository.GenerosRepository
import com.example.peliculas232.repository.PeliculasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

    @Service
    class GenerosService {
        @Autowired
        lateinit var generosRepository: GenerosRepository

        @Autowired
        lateinit var peliculasRepository: PeliculasRepository

        fun list(): List<Genero> {
            return generosRepository.findAll()
        }

        fun save(genero: Genero): Genero {
            try {
                genero.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombres no debe ser vacio")
                genero.ciudad?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Ciudad no debe ser vacio")
                peliculasRepository.findById(genero.id)
                    ?: throw Exception("Id del cliente no encontrada")
                return generosRepository.save(genero)
            } catch (ex: Exception) {
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
            }
        }

        fun update(genero: Genero): Genero{
            try {
                generosRepository.findById(genero.id)
                    ?: throw Exception("ID no existe")

                return generosRepository.save(genero)
            } catch (ex: Exception) {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
            }
        }

        fun updateName(genero: Genero): Genero {
            //try {
                generosRepository.findById(genero.id)
                    ?: throw Exception("ID no existe")
                return generosRepository.save(genero)
            //} catch (ex: Exception) {
             //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
          //  }
        }

        fun delete(id: Long?): Boolean? {
            try {
                val response = generosRepository.findById(id)
                    ?: throw Exception("ID no existe")
                generosRepository.deleteById(id!!)
                return true
            } catch (ex: Exception) {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
            }
        }

        fun listById(id: Long?): Genero? {
            return generosRepository.findById(id)
        }
}