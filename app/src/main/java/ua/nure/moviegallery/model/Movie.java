package ua.nure.moviegallery.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Actors")
    private String actors;

    public String getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "actors='" + actors + '\'' +
                '}';
    }
}