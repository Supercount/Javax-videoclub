package com.example.app.dao;

import com.example.app.dao.base.MovieDao;
import com.example.app.dao.base.UserDao;

public final class DaoFactory {

    private DaoFactory() {}

    public static MovieDao getMovieDao() {
        return new MemoryMoviesDao();
    }

    public static UserDao getUserDao() {
        return new MemoryUserDao();
    }
}
