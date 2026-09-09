package com.movie.demo.repository;

import com.movie.demo.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {



}
