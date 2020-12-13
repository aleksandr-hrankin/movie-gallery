package ua.nure.moviegallery;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.nure.moviegallery.api.MovieApiService;

public class HttpClient {
    private static final String BASE_URL = "https://kaverin-ddb.firebaseio.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static MovieApiService movieApiService = retrofit.create(MovieApiService.class);

    public static MovieApiService getMovieApiService() {
        return movieApiService;
    }
}
