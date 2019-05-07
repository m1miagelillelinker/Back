package com.hicouch.back.core.model;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    public Commentaire(String commentaire, Integer note, int idUser, int idPair, int status, Date createdat, Date updatedAt) {
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
