package ua.nure.moviegallery.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ua.nure.moviegallery.dao.MovieDao;
import ua.nure.moviegallery.db.DBHelper;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;

public class MovieDaoImpl implements MovieDao {
    private final DBHelper dbHelper;

    public MovieDaoImpl(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }


    @Override
    public void saveAll(List<MovieRequestDto> movieRequestDtos) {
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        movieRequestDtos.forEach(movie -> {
            contentValues.put(DBHelper.MOVIE_ACTORS, movie.getActors());
            contentValues.put(DBHelper.MOVIE_GENRE, movie.getGenre());
            contentValues.put(DBHelper.MOVIE_TITLE, movie.getTitle());

            writableDatabase.insert(DBHelper.MOVIE_TABLE_NAME, null, contentValues);
        });
        writableDatabase.close();
    }

    @Override
    public List<Movie> getAll() {
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DBHelper.MOVIE_TABLE_NAME,
                null, null, null, null, null, null);

        List<Movie> movies = new ArrayList<>();
        if (cursor.moveToNext()) {
            int idIndex = cursor.getColumnIndex(DBHelper.MOVIE_KEY_ID);
            int actorsIndex = cursor.getColumnIndex(DBHelper.MOVIE_ACTORS);
            int genreIndex = cursor.getColumnIndex(DBHelper.MOVIE_GENRE);
            int titleIndex = cursor.getColumnIndex(DBHelper.MOVIE_TITLE);

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
