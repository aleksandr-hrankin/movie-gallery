package ua.nure.moviegallery.repository.impl;

import java.util.List;

import io.reactivex.Observable;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;
import ua.nure.moviegallery.repository.MovieRepository;
import ua.nure.moviegallery.network.api.MovieApiService;
import ua.nure.moviegallery.service.MovieService;

public class MovieRepositoryImpl implements MovieRepository {
    private final MovieApiService movieApiService;
    private final MovieService movieService;

    public MovieRepositoryImpl(MovieApiService movieApiService, MovieService movieService) {
        this.movieApiService = movieApiService;
        this.movieService = movieService;
    }

    @Override
    public Observable<List<MovieRequestDto>> getMovieRequestDtos() {
        return Observable.create(observableEmitter -> {
            try {
                observableEmitter.onNext(movieApiService.getMovieRequestDtos());
            } catch (Exception e) {
                observableEmitter.onError(e);
            } finally {
                observableEmitter.onComplete();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        return Observable.create(observableEmitter -> {
            try {
                observableEmitter.onNext(movieService.getAll());
            } catch (Exception e) {
                observableEmitter.onError(e);
            } finally {
                observableEmitter.onComplete();
            }
        });
    }
}
