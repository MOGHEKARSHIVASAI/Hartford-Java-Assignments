package org.example.firstdemo;

import org.example.firstdemo.dao.MovieDao;
import org.example.firstdemo.dao.MovieDaoImpl;
import org.example.firstdemo.service.MovieService;
import org.example.firstdemo.service.MovieServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    @Bean
    public MovieDao getMovieDao(){
        return new MovieDaoImpl();
    }
    @Bean
    public MovieService getMovieService(MovieDao dao){
        return new MovieServiceImpl(dao);

    }
}