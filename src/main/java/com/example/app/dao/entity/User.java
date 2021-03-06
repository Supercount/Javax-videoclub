package com.example.app.dao.entity;

import com.example.app.controller.model.UserResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inscriptionDate;

    public User() {
    }

    public User(String firstName, String lastName, LocalDate birthDate, LocalDate inscriptionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.inscriptionDate = inscriptionDate;
    }

    public User(Long id, String firstName, String lastName, LocalDate birthDate, LocalDate inscriptionDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.inscriptionDate = inscriptionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDate inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public UserResponse toDto(){
        UserResponse u = new UserResponse();
        u.setId(this.id);
        u.setFirstName(this.firstName);
        u.setLastName(this.lastName);
        u.setBirthDate(this.birthDate);
        u.setInscriptionDate(this.inscriptionDate);
        return u;
    }
}
