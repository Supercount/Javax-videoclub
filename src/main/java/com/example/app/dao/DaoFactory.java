package com.example.app.dao;

import com.example.app.dao.base.MovieDao;

public final class DaoFactory {

    private DaoFactory() {}

    public static MovieDao getMovieDao() {
        return new MemoryMoviesDao();
    }
}
