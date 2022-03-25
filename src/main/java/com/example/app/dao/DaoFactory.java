package com.example.app.dao;

import com.example.app.dao.base.MovieDao;
import com.example.app.dao.base.ProductDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static MovieDao getMovieDao() {
        return new MemoryMoviesDao();
    }

    public static ProductDao getProductDao() {
        return new MemoryProductDao();
    }
}
