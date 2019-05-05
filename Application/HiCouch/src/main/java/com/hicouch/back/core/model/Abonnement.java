package com.hicouch.back.core.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idabonnement")
    int idabonnement;

    @Column(name="follower")
    Integer follower;

    @Column(name="follows")
    Integer follows;

    @Column(name="createat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    public Abonnement(Integer follower, Integer follows, Date createdat, Date updatedAt) {
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

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
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
