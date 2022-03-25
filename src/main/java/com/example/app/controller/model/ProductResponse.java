package com.example.app.controller.model;

import com.example.app.dao.entity.Movie;
import com.example.app.dao.entity.User;

import java.io.Serializable;

public class ProductResponse implements Serializable {
    private long id;
    private Movie movie;
    private boolean available;
    private User user;

    public ProductResponse(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
