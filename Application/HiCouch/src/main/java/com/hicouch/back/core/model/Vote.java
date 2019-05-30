package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="idpair")
    int idPair;

    @Column(name="vote")
    int vote;

    @Column(name="iduser")
    int idUser;

    @CreatedDate
    @Column(name="createdat",columnDefinition="datetime")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updatedat",columnDefinition="datetime")
    LocalDateTime updatedAt;

    @CreatedBy
    private String creator;

    public Vote(){}

    public Vote(int idAssoc, int vote, int idUser, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idPair = idAssoc;
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

    public int getIdPair() {
        return idPair;
    }

    public void setIdPair(int idPair) {
        this.idPair = idPair;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", idAssoc=" + idPair +
                ", vote=" + vote +
                ", idUser=" + idUser +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
