package com.example.app.controller.model;

import com.example.app.dao.entity.Movie;

import java.io.Serializable;

public class CreateProduct implements Serializable {
    private Movie movie;
    private boolean available;

    public CreateProduct(){};

    @Override
    public String toString() {
        return "CreateProduct{" +
                "movie=" + movie +
                ", available=" + available +
                '}';
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
}
