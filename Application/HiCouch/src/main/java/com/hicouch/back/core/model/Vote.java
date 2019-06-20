package com.hicouch.back.core.model;

import com.hicouch.back.core.enumeration.VoteTypeEnum;
import org.hibernate.annotations.CollectionId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="idpair")
    int idPair;

    @Column(name = "idCommentaire")
    int idCommentaire;

    @Column(name="vote")
    int vote;

    @Column(name="iduser")
    int idUser;

    @Column(name = "type")
    String type;

    @CreatedDate
    @Column(name="createdat")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updatedat")
    LocalDateTime updatedAt;

    public Vote(){}

    public Vote(int id, int vote, int idUser, LocalDateTime createdAt, LocalDateTime updatedAt, String type) {
        this.type = type;
        this.idPair = VoteTypeEnum.ASSOCIATION.equals(type) ? id : null;
        this.idCommentaire = VoteTypeEnum.COMMENTAIRE.equals(type) ? id : null;
        this.vote = vote;
        this.idUser = idUser;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", idPair=" + idPair +
                ", idCommentaire=" + idCommentaire +
                ", vote=" + vote +
                ", idUser=" + idUser +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
