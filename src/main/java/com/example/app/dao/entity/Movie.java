package com.example.app.dao.entity;

import com.example.app.controller.model.MovieResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {

    private long id;
    private String titre;
    private double duration;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(long id, String titre, double duration, LocalDate releaseDate) {
        this.id = id;
        this.titre = titre;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Movie( String titre, double duration, LocalDate releaseDate) {
        this.titre = titre;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieResponse toDto(){
        MovieResponse m = new MovieResponse();
        m.setId(this.id);
        m.setTitle(this.titre);
        m.setDuration(this.duration);
        m.setReleaseDate(this.releaseDate);
        return m;
    }
}
