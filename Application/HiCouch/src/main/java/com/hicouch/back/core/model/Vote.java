package com.hicouch.back.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="idassoc")
    int idAssoc;

    @Column(name="vote")
    int vote;

    @Column(name="iduser")
    int idUser;

    @Column(name="createdat")
    Date createdAt;

    @Column(name="updatedat")
    Date updatedAt;

    public Vote(){}

    public Vote(int idAssoc, int vote, int idUser, Date createdAt, Date updatedAt) {
        this.idAssoc = idAssoc;
        this.vote = vote;
        this.idUser = idUser;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAssoc() {
        return idAssoc;
    }

    public void setIdAssoc(int idAssoc) {
        this.idAssoc = idAssoc;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", idAssoc=" + idAssoc +
                ", vote=" + vote +
                ", idUser=" + idUser +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}