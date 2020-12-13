package ua.nure.moviegallery.service.impl;

import java.util.List;
import ua.nure.moviegallery.dao.MovieDao;
import ua.nure.moviegallery.model.Movie;
import ua.nure.moviegallery.model.dto.MovieRequestDto;
import ua.nure.moviegallery.service.MovieService;

public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void saveAll(List<MovieRequestDto> movieRequestDtos) {
        movieDao.saveAll(movieRequestDtos);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
