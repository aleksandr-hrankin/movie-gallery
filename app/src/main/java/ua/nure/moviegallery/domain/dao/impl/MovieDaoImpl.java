package ua.nure.moviegallery.domain.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ua.nure.moviegallery.domain.dao.MovieDao;
import ua.nure.moviegallery.domain.db.DatabaseHelper;
import ua.nure.moviegallery.domain.model.Movie;
import ua.nure.moviegallery.domain.model.dto.request.MovieRequestDto;

public class MovieDaoImpl implements MovieDao {
    private final DatabaseHelper databaseHelper;

    public MovieDaoImpl(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public void saveAll(List<MovieRequestDto> movieRequestDtos) {
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        movieRequestDtos.forEach(movie -> {
            contentValues.put(DatabaseHelper.MOVIE_ACTORS, movie.getActors());
            contentValues.put(DatabaseHelper.MOVIE_GENRE, movie.getGenre());
            contentValues.put(DatabaseHelper.MOVIE_TITLE, movie.getTitle());

            writableDatabase.insert(DatabaseHelper.MOVIE_TABLE_NAME, null, contentValues);
        });
        writableDatabase.close();
    }

    @Override
    public List<Movie> getAll() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DatabaseHelper.MOVIE_TABLE_NAME,
                null, null, null, null, null, null);

        List<Movie> movies = new ArrayList<>();
        if (cursor.moveToNext()) {
            int idIndex = cursor.getColumnIndex(DatabaseHelper.MOVIE_KEY_ID);
            int actorsIndex = cursor.getColumnIndex(DatabaseHelper.MOVIE_ACTORS);
            int genreIndex = cursor.getColumnIndex(DatabaseHelper.MOVIE_GENRE);
            int titleIndex = cursor.getColumnIndex(DatabaseHelper.MOVIE_TITLE);

            do {
                Movie movie = new Movie();
                movie.setId(cursor.getLong(idIndex));
                movie.setActors(cursor.getString(actorsIndex));
                movie.setGenre(cursor.getString(genreIndex));
                movie.setTitle(cursor.getString(titleIndex));
                movies.add(movie);
            } while (cursor.moveToNext());
        } else {
            return Collections.emptyList();
        }
        cursor.close();
        return movies;
    }
}
