package ua.nure.moviegallery.api;

import java.util.List;

import retrofit2.http.GET;
import ua.nure.moviegallery.model.dto.MovieRequestDto;

public interface MovieApiService {
    @GET("dbs/movies.json?print=pretty")
    List<MovieRequestDto> getMovieRequestDtos();
}
