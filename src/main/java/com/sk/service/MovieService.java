package com.sk.service;


import com.sk.model.Movie;
import com.sk.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public List <Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMoviePreference(Movie movie) {
        return movieRepository.save(movie);
    }

    public List <String> getRecommendation(String title) {
        List <Movie> recommendations = movieRepository.getRecommendations(title);
        log.debug("recommendation count {}", recommendations.size());
        List<String> recommendationList = new ArrayList <>() ;
        for (Movie movie : recommendations) {
            recommendationList.add(movie.getAlsoViewedTitle());
        }
        return recommendationList;
    }


}
