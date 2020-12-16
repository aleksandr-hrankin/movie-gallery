package ua.nure.moviegallery.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.List;
import ua.nure.moviegallery.presentation.holder.MovieViewHolder;
import ua.nure.moviegallery.domain.model.Movie;

public class ClickMovieRecyclerAdapter extends MovieRecyclerAdapter implements View.OnClickListener {
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private final OnItemClickListener onItemClickListener;

    public ClickMovieRecyclerAdapter(List<Movie> movies,
                                     LayoutInflater layoutInflater,
                                     OnItemClickListener onItemClickListener) {
        super(movies, layoutInflater);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieViewHolder movieViewHolder = super.onCreateViewHolder(parent, viewType);
        movieViewHolder.itemView.setOnClickListener(this);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.itemView.setTag(position);
    }

    @Override
    public void onClick(View view) {
        Integer position = (Integer) view.getTag();
        onItemClickListener.onItemClick(view, position);
    }
}
