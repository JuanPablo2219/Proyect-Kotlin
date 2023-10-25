package com.example.peliculas232.controller

import com.example.peliculas232.model.Genero
import com.example.peliculas232.model.Pelicula
import com.example.peliculas232.service.GenerosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/generos")
class GenerosController {
    @Autowired
    lateinit var generosService: GenerosService

    @GetMapping
    fun list ():List <Genero> {
        return generosService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(generosService.listById(id), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody genero: Genero):ResponseEntity<Genero>{
        return ResponseEntity(generosService.save(genero), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody genero: Genero):ResponseEntity<Genero>{
        return ResponseEntity(generosService.update(genero), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody genero: Genero):ResponseEntity<Genero>{
        return ResponseEntity(generosService.updateName(genero), HttpStatus.OK)
    }

    @DeleteMapping("/generos/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return generosService.delete(id)
    }
    }