package org.example.firstdemo.dao;

import org.example.firstdemo.entity.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieDaoImpl implements MovieDao{
    Map<Integer, Movie> movies = new HashMap<>();


    @Override
    public void addMovie(Movie m) {
           movies.put(m.getId(),m);
    }

    @Override
    public Movie findMovieById(int id) {
        if(movies.containsKey(id)){
            return movies.get(id);
        }
        System.out.println("Movie with id "+id+" is not found");
        return null;
    }

    @Override
    public void deleteMovie(int id) {
          if(movies.containsKey(id)){
                movies.remove(id);
              System.out.println("Movie with id "+id+" is deleted successfully");
              return;
          }
        System.out.println("Movie with id "+id+" is not found");
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
