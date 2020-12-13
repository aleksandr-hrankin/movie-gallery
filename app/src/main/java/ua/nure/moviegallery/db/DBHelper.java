package ua.nure.moviegallery.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "movie_gallery_db";
    public static final int DATABASE_VERSION = 2;

    public static final String MOVIE_TABLE_NAME = "movie";
    public static final String MOVIE_KEY_ID = "_id";
    public static final String MOVIE_ACTORS = "actors";
    public static final String MOVIE_GENRE = "genre";
    public static final String MOVIE_TITLE = "title";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createMovieTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + MOVIE_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void createMovieTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + MOVIE_TABLE_NAME + "("
                + MOVIE_KEY_ID + " integer primary key, "
                + MOVIE_ACTORS + " text, "
                + MOVIE_GENRE + " text, "
                + MOVIE_TITLE + " text)");
    }
}
