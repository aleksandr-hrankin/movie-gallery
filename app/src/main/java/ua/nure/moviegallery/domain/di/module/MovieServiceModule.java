package ua.nure.moviegallery.domain.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import ua.nure.moviegallery.date.NetworkService;
import ua.nure.moviegallery.date.api.MovieApiService;
import ua.nure.moviegallery.domain.dao.MovieDao;
import ua.nure.moviegallery.domain.dao.impl.MovieDaoImpl;
import ua.nure.moviegallery.domain.db.DatabaseHelper;
import ua.nure.moviegallery.domain.repository.MovieRepository;
import ua.nure.moviegallery.domain.repository.impl.MovieRepositoryImpl;
import ua.nure.moviegallery.domain.service.MovieService;
import ua.nure.moviegallery.domain.service.impl.MovieServiceImpl;

@Module
public class MovieServiceModule {
    private final Context context;

    public MovieServiceModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public MovieDao provideMovieDao(DatabaseHelper databaseHelper) {
        return new MovieDaoImpl(databaseHelper);
    }

    @Provides
    @Singleton
    public MovieService provideMovieService(MovieDao movieDao) {
        return new MovieServiceImpl(movieDao);
    }

    @Provides
    @Singleton
    public DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper(context);
    }

    @Provides
    @Singleton
    public MovieApiService provideMovieApiService() {
        return NetworkService.getMovieApiService();
    }

    @Provides
    @Singleton
    public MovieRepository movieRepository(MovieService movieService) {
        return new MovieRepositoryImpl(movieService);
    }
}
