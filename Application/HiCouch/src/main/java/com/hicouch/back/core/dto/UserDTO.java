package com.hicouch.back.core.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Integer typeUser;
    private String pseudo;
    private Integer score;
    private Integer idstatus;
    private String picture;
    private LocalDateTime lastlogin;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserDTO(String firstName, String lastName, String email, Integer typeUser, String pseudo, Integer score, Integer idstatus, String picture, LocalDateTime lastlogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.typeUser = typeUser;
        this.pseudo = pseudo;
        this.score = score;
        this.idstatus = idstatus;
        this.picture = picture;
        this.lastlogin = lastlogin;
    }

    /**
     *
     */
    public UserDTO() {
        super();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public LocalDateTime getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(LocalDateTime lastlogin) {
        this.lastlogin = lastlogin;
    }
}
