package com.example.app;

import com.example.app.dao.DaoFactory;
import com.example.app.dao.base.MovieDao;
import com.example.app.dao.base.UserDao;
import com.example.app.dao.entity.Movie;
import com.example.app.dao.entity.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(new Movie("La ligne verte", 188, LocalDate.ofYearDay(1999, 1)));
        movieDao.save(new Movie("Le parrain", 175, LocalDate.ofYearDay(1972, 1)));
        movieDao.save(new Movie("H2G2 ", 109, LocalDate.ofYearDay(2005, 1)));
        movieDao.save(new Movie("Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1)));
        movieDao.save(new Movie("Les affranchis", 146, LocalDate.ofYearDay(1990, 1)));
        movieDao.save(new Movie("Metropolis", 153, LocalDate.ofYearDay(1927, 1)));
        movieDao.save(new Movie("Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1)));
        movieDao.save(new Movie("Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1)));
        movieDao.save(new Movie("Transformers", 224, LocalDate.ofYearDay(2007, 1)));

    }
}