package ua.nure.moviegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import ua.nure.moviegallery.api.HttpClient;
import ua.nure.moviegallery.api.MovieApiService;
import ua.nure.moviegallery.model.Movie;

public class MainActivity extends AppCompatActivity {

    private MovieApiService movieApiService = HttpClient.getMovieApiService();
    private TextView tvStatus, tvInfo;
    private Button btnHttpRequest, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        tvInfo = findViewById(R.id.tvInfo);
        btnHttpRequest = findViewById(R.id.btnHttpRequest);
        btnReset = findViewById(R.id.btnReset);

        btnHttpRequest.setOnClickListener(view -> {
            exe();
        });

        btnReset.setOnClickListener(view -> {
            tvStatus.setText("Press below button to fire HTTP request");
            tvInfo.setText("No data");
        });
    }

    private void exe() {
        tvStatus.setText("HTTP Request in progress.");
        movieApiService.getMovies()
                .observeOn(SchedulerProvider.ui())
                .subscribeOn(SchedulerProvider.io())
                .subscribe(movies -> {
                            tvStatus.setText("Request Completed!");
                            movies.forEach(movie -> tvInfo.append(movie.toString()));
                        }, throwable -> throwable.printStackTrace()
                );
    }
}