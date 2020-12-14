package ua.nure.moviegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ua.nure.moviegallery.adapter.ClickMovieRecyclerAdapter;
import ua.nure.moviegallery.dao.MovieDao;
import ua.nure.moviegallery.dao.impl.MovieDaoImpl;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.network.HttpClient;
import ua.nure.moviegallery.network.NetworkChangeReceiver;
import ua.nure.moviegallery.repository.MovieRepository;
import ua.nure.moviegallery.repository.impl.MovieRepositoryImpl;
import ua.nure.moviegallery.service.MovieService;
import ua.nure.moviegallery.network.api.MovieApiService;
import ua.nure.moviegallery.db.DBHelper;
import ua.nure.moviegallery.service.impl.MovieServiceImpl;

public class MainActivity extends AppCompatActivity implements ClickMovieRecyclerAdapter.OnItemClickListener {

    private DBHelper dbHelper = new DBHelper(this);
    private MovieApiService movieApiService = HttpClient.getMovieApiService();
    private MovieDao movieDao = new MovieDaoImpl(dbHelper);
    private MovieService movieService = new MovieServiceImpl(movieDao);
    private MovieRepository movieRepository = new MovieRepositoryImpl(movieApiService, movieService);

    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = movieService.getAll();

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setAdapter(new ClickMovieRecyclerAdapter(movies, getLayoutInflater(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        setContentView(recyclerView);

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


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, movies.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
