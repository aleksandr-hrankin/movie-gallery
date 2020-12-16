package ua.nure.moviegallery.domain.service.impl;

import java.util.List;
import ua.nure.moviegallery.domain.dao.MovieDao;
import ua.nure.moviegallery.domain.model.Movie;
import ua.nure.moviegallery.domain.model.dto.request.MovieRequestDto;
import ua.nure.moviegallery.domain.service.MovieService;

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
