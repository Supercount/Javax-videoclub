package com.example.app.dao.entity;


import com.example.app.controller.model.EventResponse;
import com.example.app.controller.model.MovieResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event implements Serializable {

    private long id;
    private String title;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startingDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endingDate;
    private List<User> participants = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public Event(){}

    public Event(String title, LocalDate startingDate, LocalDate endingDate, List<User> participants, List<Movie> movies) {
        this.id = id;
        this.title = title;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.participants = participants;
        this.movies = movies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", participants=" + participants +
                ", movies=" + movies +
                '}';
    }

    public EventResponse toDto(){
        EventResponse e = new EventResponse();
        e.setId(this.id);
        e.setTitle(this.title);
        e.setStartingDate(this.startingDate);
        e.setEndingDate(this.endingDate);
        e.setMovies(this.movies);
        e.setParticipants(this.participants);
        return e;
    }
}
