package ua.nure.moviegallery.date.api;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;
import ua.nure.moviegallery.domain.model.dto.request.MovieRequestDto;

public interface MovieApiService {
    @GET("dbs/movies.json?print=pretty")
    Observable<List<MovieRequestDto>> getMovieRequestDtos();
}
