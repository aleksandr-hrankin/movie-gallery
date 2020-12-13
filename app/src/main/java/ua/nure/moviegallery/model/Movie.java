package ua.nure.moviegallery.model;

import java.util.Objects;

public class Movie {
    private Long id;
    private String actors;
    private String genre;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actors, genre, title);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", actors='" + actors + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
