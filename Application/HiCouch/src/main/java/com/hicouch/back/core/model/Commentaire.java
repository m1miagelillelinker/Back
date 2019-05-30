package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Integer id;

    @Column(name="Commentaire")
    String commentaire;

    @Column(name="Note")
    Integer note;

    @Column(name="iduser")
    int idUser;

    @Column(name="idpair")
    int idPair;

    @Column(name="status")
    int status;

    @CreatedDate
    @Column(name="createdat",columnDefinition="datetime")
    LocalDateTime createdat;

    @LastModifiedBy
    @Column(name="updatedat",columnDefinition="datetime")
    LocalDateTime updatedAt;

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String modificator;

    public Commentaire(String commentaire, Integer note, int idUser, int idPair, int status, LocalDateTime createdat, LocalDateTime updatedAt) {
        this.commentaire = commentaire;
        this.note = note;
        this.idUser = idUser;
        this.idPair = idPair;
        this.status = status;
        this.createdat = createdat;
        this.updatedAt = updatedAt;
    }

    public Commentaire(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPair() {
        return idPair;
    }

    public void setIdPair(int idPair) {
        this.idPair = idPair;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "Commentaire{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", idUser=" + idUser +
                ", idPair=" + idPair +
                ", status=" + status +
                ", createdat=" + createdat +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
