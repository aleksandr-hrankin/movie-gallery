package ua.nure.moviegallery.service;

import java.util.List;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;

public interface MovieService {
    void saveAll(List<MovieRequestDto> movieRequestDtos);

    List<Movie> getAll();
}
