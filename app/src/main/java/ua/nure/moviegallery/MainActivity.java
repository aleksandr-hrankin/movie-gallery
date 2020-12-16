package ua.nure.moviegallery;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import javax.inject.Inject;
import ua.nure.moviegallery.date.api.MovieApiService;
import ua.nure.moviegallery.domain.SchedulerProvider;
import ua.nure.moviegallery.domain.model.Movie;
import ua.nure.moviegallery.domain.repository.MovieRepository;
import ua.nure.moviegallery.domain.service.MovieService;
import ua.nure.moviegallery.presentation.adapter.ClickMovieRecyclerAdapter;

public class MainActivity extends AppCompatActivity implements ClickMovieRecyclerAdapter.OnItemClickListener {
    @Inject
    MovieApiService movieApiService;
    @Inject
    MovieService movieService;
    @Inject
    MovieRepository movieRepository;

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getMovieServiceComponent().inject(this);

        movieApiService.getMovieRequestDtos()
                .subscribeOn(SchedulerProvider.io())
                .observeOn(SchedulerProvider.ui())
                .subscribe(movieRequestDtos -> movieService.saveAll(movieRequestDtos));

        movies = movieService.getAll();

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setAdapter(new ClickMovieRecyclerAdapter(movies, getLayoutInflater(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        setContentView(recyclerView);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, movies.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
