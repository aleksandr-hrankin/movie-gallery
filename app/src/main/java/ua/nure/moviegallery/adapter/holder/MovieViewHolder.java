package ua.nure.moviegallery.adapter.holder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ua.nure.moviegallery.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView tvActors;
    private TextView tvGenre;
    private TextView tvTitle;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        tvActors = itemView.findViewById(R.id.tv_actors);
        tvGenre = itemView.findViewById(R.id.tv_genre);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

    public void setActors(String actors) {
        tvActors.setText(actors);
    }

    public void setGenre(String genre) {
        tvGenre.setText(genre);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }
}
