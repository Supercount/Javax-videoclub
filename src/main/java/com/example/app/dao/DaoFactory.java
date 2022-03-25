package com.example.app.dao;

import com.example.app.controller.EventController;
import com.example.app.dao.base.EventDao;
import com.example.app.dao.base.MovieDao;

public final class DaoFactory {

    private DaoFactory() {}

    public static MovieDao getMovieDao() {
        return new MemoryMoviesDao();
    }

    public static EventDao getEventDao() {
        return new MemoryEventDao();
    }
}
