package ua.nure.moviegallery.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.nure.moviegallery.model.Movie;

public interface MovieApi {
    @GET("dbs/movies.json?print=pretty")
    Call<List<Movie>> getMovies();
}
