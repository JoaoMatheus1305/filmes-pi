package com.movie.demo.services;

import com.movie.demo.model.MovieModel;
import com.movie.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieModel> findAll(){
        return movieRepository.findAll();
    }

    public MovieModel buscarPorId(Long id){
        return movieRepository.findById(id).get();
    }

    public MovieModel criarFilme(MovieModel movieModel){
        return movieRepository.save(movieModel);
    }

    public void deletarFilme(Long id) {
        movieRepository.deleteById(id);
    }

    public MovieModel atualizarFilme(Long id, MovieModel movieNew) {
        MovieModel movieModel = movieRepository.findById(id).get();
        movieModel.setTitulo(movieNew.getTitulo());
        movieModel.setGenero(movieNew.getGenero());
        movieModel.setAno(movieNew.getAno());
        movieModel.setNota(movieNew.getNota());
        movieModel.setDescricao(movieNew.getDescricao());
        movieModel.setEstudio(movieNew.getEstudio());

        return movieRepository.save(movieModel);
    }
}
