package ua.nure.moviegallery.domain.repository;

import java.util.List;
import io.reactivex.Observable;
import ua.nure.moviegallery.domain.model.Movie;

public interface MovieRepository {
    Observable<List<Movie>> getObservableMoviesFromDb();
}
