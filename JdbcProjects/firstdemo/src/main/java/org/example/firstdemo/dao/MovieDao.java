package org.example.firstdemo.dao;

import org.example.firstdemo.entity.Movie;

public interface MovieDao {
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
