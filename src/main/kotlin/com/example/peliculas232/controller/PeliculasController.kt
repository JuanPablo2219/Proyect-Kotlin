package com.example.peliculas232.controller

import com.example.peliculas232.model.Pelicula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.peliculas232.service.PeliculasService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/peliculas")
class PeliculasController {
    @Autowired
    lateinit var peliculasService: PeliculasService

    @GetMapping
    fun list ():List <Pelicula>{
        return peliculasService.list()
    }

    @PostMapping
    fun save (@RequestBody pelicula: Pelicula):ResponseEntity<Pelicula>{
        return ResponseEntity(peliculasService.save(pelicula), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody pelicula: Pelicula):ResponseEntity<Pelicula>{
        return ResponseEntity(peliculasService.update(pelicula), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody pelicula: Pelicula):ResponseEntity<Pelicula>{
        return ResponseEntity(peliculasService.updateName(pelicula), HttpStatus.OK)
    }

    @DeleteMapping("/peliculas/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return peliculasService.delete(id)
    }
}