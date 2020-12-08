package ua.nure.moviegallery.api;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import ua.nure.moviegallery.model.Movie;

public interface MovieApiService {
    @GET("dbs/movies.json?print=pretty")
    Flowable<List<Movie>> getMovies();
}
