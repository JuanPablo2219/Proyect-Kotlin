package com.example.peliculas232.service

import com.example.peliculas232.model.Pelicula
import com.example.peliculas232.repository.GenerosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import com.example.peliculas232.repository.PeliculasRepository

@Service
class PeliculasService {
    @Autowired
    lateinit var peliculasRepository: PeliculasRepository

    @Autowired
    lateinit var generosRepository: GenerosRepository

    fun list ():List<Pelicula>{
        return peliculasRepository.findAll()
    }

    fun save(pelicula: Pelicula): Pelicula {
        try{
            pelicula.titulo?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Titulo no debe ser vacio")
            pelicula.productor?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Productor no debe ser vacio")
            generosRepository.findById(pelicula.generosId)
                ?: throw Exception("Id del cliente no encontrada")
            return peliculasRepository.save(pelicula)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }
    }

    fun update(pelicula: Pelicula): Pelicula{
        try {
            peliculasRepository.findById(pelicula.id)
                ?: throw Exception("ID no existe")

            return peliculasRepository.save(pelicula)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(pelicula: Pelicula): Pelicula{
        try{
            val response = peliculasRepository.findById(pelicula.id)
                ?: throw Exception("ID no existe")
            response.apply {
                productor=pelicula.productor
            }
            return peliculasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = peliculasRepository.findById(id)
                ?: throw Exception("ID no existe")
            peliculasRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Pelicula?{
        return peliculasRepository.findById(id)
    }
}