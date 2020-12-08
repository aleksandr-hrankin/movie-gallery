package ua.nure.moviegallery.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.nure.moviegallery.model.Movie;

public class MovieApiImpl {
    private static final String BASE_URL = "https://kaverin-ddb.firebaseio.com/";

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void exe() throws RuntimeException {
        MovieApi movieApi = getRetrofit().create(MovieApi.class);
        Call<List<Movie>> call = movieApi.getMovies();
        System.out.println("tyt");
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                response.body().forEach(System.out::println);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                throw new RuntimeException("Can't to load movies " + t.toString());
            }
        });
    }
}
