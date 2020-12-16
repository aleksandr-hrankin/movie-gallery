package ua.nure.moviegallery.domain.repository.impl;

import java.util.List;
import io.reactivex.Observable;
import ua.nure.moviegallery.domain.model.Movie;
import ua.nure.moviegallery.domain.repository.MovieRepository;
import ua.nure.moviegallery.domain.service.MovieService;

public class MovieRepositoryImpl implements MovieRepository {
    private final MovieService movieService;

    public MovieRepositoryImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Observable<List<Movie>> getObservableMoviesFromDb() {
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
