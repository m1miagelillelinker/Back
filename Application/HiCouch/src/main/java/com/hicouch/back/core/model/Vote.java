package com.hicouch.back.core.model;

import com.hicouch.back.core.enumeration.VoteTypeEnum;
import org.springframework.data.annotation.CreatedDate;
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
    Integer idPair;

    @Column(name = "idcommentaire")
    Integer idCommentaire;

    @Column(name="vote")
    Integer vote;

    @Column(name="iduser")
    Integer idUser;

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
        if ( VoteTypeEnum.ASSOCIATION.equals(type) ) {
        	this.idPair = id;
        } else {
        	this.idCommentaire = id;
        }
        
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

    public Integer getIdPair() {
        return idPair;
    }

    public void setIdPair(Integer idPair) {
        this.idPair = idPair;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Integer idCommentaire) {
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
