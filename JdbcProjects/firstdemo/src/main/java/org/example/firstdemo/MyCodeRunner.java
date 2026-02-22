package org.example.firstdemo;

import org.example.firstdemo.MyAppConfig;

import org.example.firstdemo.entity.Movie;
import org.example.firstdemo.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCodeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hi , I am running!!!");
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(MyAppConfig.class);
        MovieService movieService = ctxt.getBean(MovieService.class);
        Movie m = new Movie(1,"Shole","Ramesh" ,"Action","12-12-1995");
        movieService.addMovie(m);
        System.out.println("find movie by id in the database");
        System.out.println(movieService.findMovieById(1));

        ctxt.close();
    }
}