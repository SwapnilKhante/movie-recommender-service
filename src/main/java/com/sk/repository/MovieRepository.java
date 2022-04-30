package com.sk.repository;


import com.sk.model.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CassandraRepository<Movie, String> {

  @Override
  List <Movie> findAll();

  @Override
  <S extends Movie> S save(S entity);

  @Query("Select also_viewed_title from movie where title = ?0")
  List<Movie> getRecommendations(String title);

}
