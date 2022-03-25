package com.example.app.dao.entity;

import com.example.app.controller.model.ProductResponse;

public class Product {
    private long id;
    private Movie movie;
    private boolean available;
    private User user;

    public Product() {
    }

    public Product(Movie movie, boolean available) {
        this.movie = movie;
        this.available = available;
    }

    public Product(long id, Movie movie, boolean available, User user) {
        this.id = id;
        this.movie = movie;
        this.available = available;
        this.user = user;
    }

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

    public ProductResponse toDto(){
        ProductResponse p = new ProductResponse();
        p.setId(this.id);
        p.setMovie(this.movie);
        p.setAvailable(this.available);
        p.setUser(this.user);
        return p;
    }
}
