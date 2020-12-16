package ua.nure.moviegallery.domain.service;

import java.util.List;
import ua.nure.moviegallery.domain.model.Movie;
import ua.nure.moviegallery.domain.model.dto.request.MovieRequestDto;

public interface MovieService {
    void saveAll(List<MovieRequestDto> movieRequestDtos);

    List<Movie> getAll();
}
