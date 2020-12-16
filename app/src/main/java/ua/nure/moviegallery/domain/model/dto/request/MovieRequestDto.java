package ua.nure.moviegallery.domain.model.dto.request;

import com.google.gson.annotations.SerializedName;

public class MovieRequestDto {
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Title")
    private String title;

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "actors='" + actors + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
