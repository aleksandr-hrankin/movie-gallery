package ua.nure.moviegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.nure.moviegallery.api.MovieApi;
import ua.nure.moviegallery.api.MovieApiImpl;
import ua.nure.moviegallery.model.Movie;

public class MainActivity extends AppCompatActivity {

    private TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = findViewById(R.id.tw);
        tw.setText("working");

        new MovieApiImpl().exe();
    }
}