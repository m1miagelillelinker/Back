package com.hicouch.back.core.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idabonnement")
    int idabonnement;

    @Column(name="follower")
    Integer follower;

    @Column(name="follows")
    Integer follows;

    @CreatedDate
    @Column(name="createat")
    LocalDateTime createdat;

    @LastModifiedDate
    @Column(name="updatedat")
    LocalDateTime updatedAt;

    public Abonnement(Integer follower, Integer follows, LocalDateTime createdat, LocalDateTime updatedAt) {
        this.follower = follower;
        this.follows = follows;
        this.createdat = createdat;
        this.updatedAt = updatedAt;
    }

    public Abonnement(){}

    public int getIdabonnement() {
        return idabonnement;
    }

    public void setIdabonnement(int idabonnement) {
        this.idabonnement = idabonnement;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getFollows() {
        return follows;
    }

    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "idabonnement=" + idabonnement +
                ", follower='" + follower + '\'' +
                ", follows='" + follows + '\'' +
                ", createdat=" + createdat +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
