package com.sk.controller;


import com.sk.model.Movie;
import com.sk.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/movie-project/")
@RestController
public class MovieController {

  private final MovieService movieService;

  @GetMapping(produces = { "application/json" }, path = "movies")
  public ResponseEntity<List <Movie>> getAllMovies() {

    return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
  }

  @PostMapping("movies")
  public ResponseEntity<Movie> saveMoviePreference(@Validated @RequestBody Movie movie) {

    Movie savedMovieReference = movieService.saveMoviePreference(movie);

    return new ResponseEntity<>(savedMovieReference, HttpStatus.OK);

  }

  @GetMapping(produces = { "application/json" }, path = "/getRecommendation/{title}")
  public ResponseEntity<List<String>> getRecommendedMovie(@PathVariable String title) {

    List<String> recommendations = movieService.getRecommendation(title);
    return new ResponseEntity<>(recommendations, HttpStatus.OK);
  }
}
