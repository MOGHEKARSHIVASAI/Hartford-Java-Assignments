package org.example.firstdemo.service;

import org.example.firstdemo.dao.MovieDao;
import org.example.firstdemo.dao.MovieDaoImpl;
import org.example.firstdemo.entity.Movie;

public class MovieServiceImpl implements MovieService{
     private MovieDao dao;
    public MovieServiceImpl(MovieDao dao) {
        this.dao = dao;
    }
    @Override
    public void addMovie(Movie m) {
        dao.addMovie(m);
    }



    @Override
    public void deleteMovie(int id) {
          dao.deleteMovie(id);
    }

    @Override
    public Movie findMovieById(int id) {
        return dao.findMovieById(id);
    }

    @Override
    public void updateMovie(Movie m) {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void sortByRating() {

    }

    @Override
    public void sortByGenre() {

    }

    @Override
    public void filterByGenre(String genre) {

    }

    @Override
    public void filterByRating(double minrating, double maxrating) {

    }
}
