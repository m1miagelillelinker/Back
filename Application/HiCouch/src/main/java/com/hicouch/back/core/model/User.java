package com.hicouch.back.core.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="utilisateur")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="gender")
    private Integer gender;

    @Column(name="email")
    private String email;

    @Column(name="typeuser")
    private String typeUser;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="score")
    private Integer score;

    @Column(name= "password")
    private String password;

    @Column(name = "idstatus")
    private Integer idstatus;

    @Column(name= "picture")
    private String picture;

    @Column(name="createdat")
    private Date createdAt;

    @Column(name="updatedat")
    private Date updatedAt;

    @Column(name="lastlogin")
    private Date lastlogin;

    @Column(name="loginscount")
    private Integer loginscount;

    public User() {
    }

    public User(String firstName, String lastName, Integer gender, String email, String typeUser, String pseudo, Integer score, String password, Integer idstatus, String picture, Date createdAt, Date updatedAt, Date lastlogin, Integer loginscount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.typeUser = typeUser;
        this.pseudo = pseudo;
        this.score = score;
        this.password = password;
        this.idstatus = idstatus;
        this.picture = picture;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastlogin = lastlogin;
        this.loginscount = loginscount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Integer getLoginscount() {
        return loginscount;
    }

    public void setLoginscount(Integer loginscount) {
        this.loginscount = loginscount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", typeUser='" + typeUser + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", score=" + score +
                ", password='" + password + '\'' +
                ", idstatus=" + idstatus +
                ", picture='" + picture + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", lastlogin=" + lastlogin +
                ", loginscount=" + loginscount +
                '}';
    }
}
