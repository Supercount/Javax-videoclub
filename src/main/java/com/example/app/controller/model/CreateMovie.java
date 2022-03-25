package com.example.app.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateMovie implements Serializable {

    private String titre;
    private double duration;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    public CreateMovie() {
    }

    @Override
    public String toString() {
        return "CreateMovie{" +
                "titre='" + titre + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                '}';
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
}
