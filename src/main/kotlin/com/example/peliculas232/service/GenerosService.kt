package com.example.peliculas232.service

import com.example.peliculas232.model.Genero
import com.example.peliculas232.repository.GenerosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

    @Service
    class GenerosService {
        @Autowired
        lateinit var generosRepository: GenerosRepository

        fun list(): List<Genero> {
            return generosRepository.findAll()
        }

        fun save(genero: Genero): Genero {
            try {
                return generosRepository.save(genero)
            } catch (ex: Exception) {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
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