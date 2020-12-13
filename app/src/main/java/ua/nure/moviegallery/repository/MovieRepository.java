package ua.nure.moviegallery.repository;

import java.util.List;

import io.reactivex.Observable;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;

public interface MovieRepository {
    Observable<List<MovieRequestDto>> getMovieRequestDtos();

    Observable<List<Movie>> getMovies();
}
