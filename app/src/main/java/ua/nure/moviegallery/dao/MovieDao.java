package ua.nure.moviegallery.dao;

import java.util.List;

import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;

public interface MovieDao {
    void saveAll(List<MovieRequestDto> movieRequestDtos);

    List<Movie> getAll();
}
