package ua.nure.moviegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import ua.nure.moviegallery.dao.MovieDao;
import ua.nure.moviegallery.dao.impl.MovieDaoImpl;
import ua.nure.moviegallery.repository.MovieRepository;
import ua.nure.moviegallery.repository.impl.MovieRepositoryImpl;
import ua.nure.moviegallery.service.MovieService;
import ua.nure.moviegallery.api.MovieApiService;
import ua.nure.moviegallery.db.DBHelper;
import ua.nure.moviegallery.service.impl.MovieServiceImpl;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper = new DBHelper(this);
    private MovieApiService movieApiService = HttpClient.getMovieApiService();
    private MovieDao movieDao = new MovieDaoImpl(dbHelper);
    private MovieService movieService = new MovieServiceImpl(movieDao);
    private MovieRepository movieRepository = new MovieRepositoryImpl(movieApiService, movieService);

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);

//        movieApiService.getMovieRequestDtos()
//                .observeOn(SchedulerProvider.ui())
//                .subscribeOn(SchedulerProvider.io())
//                .subscribe(movieRequestDtos -> {
//
//                        },
//                        throwable -> {
//
//                        }
//                );

        initBroadcastReceiver();
    }

    private void initBroadcastReceiver() {
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeReceiver, intentFilter);
    }
}
