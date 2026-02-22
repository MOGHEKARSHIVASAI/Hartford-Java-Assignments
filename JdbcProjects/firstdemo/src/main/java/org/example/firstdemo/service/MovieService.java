package org.example.firstdemo.service;

import org.example.firstdemo.entity.Movie;

public interface MovieService {
    void addMovie(Movie m);
    Movie findMovieById(int id);
    void deleteMovie(int id);
    void updateMovie(Movie m);
    void sortByName();
    void sortByRating();
    void sortByGenre();
    void filterByGenre(String genre);
    void filterByRating(double minrating,double maxrating);
}
