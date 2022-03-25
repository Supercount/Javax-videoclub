package com.example.app.controller.model;

import com.example.app.dao.entity.Movie;
import com.example.app.dao.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventModel implements Serializable {

    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startingDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endingDate;
    private List<User> participants = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public EventModel(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "title='" + title + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", participants=" + participants +
                ", movies=" + movies +
                '}';
    }
}
