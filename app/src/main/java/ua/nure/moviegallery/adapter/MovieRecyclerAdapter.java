package ua.nure.moviegallery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;
import ua.nure.moviegallery.R;
import ua.nure.moviegallery.adapter.holder.MovieViewHolder;
import ua.nure.moviegallery.model.Movie;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final List<Movie> movies;
    private final WeakReference<LayoutInflater> inflaterWeakReference;

    public MovieRecyclerAdapter(List<Movie> movies, LayoutInflater layoutInflater) {
        this.movies = movies;
        inflaterWeakReference = new WeakReference<>(layoutInflater);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = inflaterWeakReference.get();
        if (inflater != null) {
            return new MovieViewHolder(inflater.inflate(R.layout.movie_item_layout, parent, false));
        } else {
            throw new RuntimeException("Activity is dead");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.setActors(movie.getActors());
        holder.setGenre(movie.getGenre());
        holder.setTitle(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
