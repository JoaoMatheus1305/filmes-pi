package com.example.filmes.controller;

import com.example.filmes.models.MovieModel;
import com.example.filmes.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieModel>> findAll(){

        List<MovieModel> response = movieService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<MovieModel> criarFilme(@RequestBody MovieModel movieModel){
        MovieModel response = movieService.criarFilme(movieModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarId( @PathVariable Long id){
        movieService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> atualizarFilme(@PathVariable Long id, @RequestBody MovieModel movieModel) {
        MovieModel response = movieService.atualizarFilme(id, movieModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> buscarId( @PathVariable Long id){
        MovieModel response = movieService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }



}
