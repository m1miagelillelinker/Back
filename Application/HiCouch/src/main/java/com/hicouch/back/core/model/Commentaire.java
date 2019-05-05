package com.hicouch.back.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="Commentaire")
    String commentaire;

    @Column(name="Note")
    int note;

    @Column(name="iduser")
    int idUser;

    @Column(name="idassoc")
    int idAssoc;

    @Column(name="status")
    int status;

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    public Commentaire(String commentaire, int note, int idUser, int idAssoc, int status, Date createdat, Date updatedAt) {
        this.commentaire = commentaire;
        this.note = note;
        this.idUser = idUser;
        this.idAssoc = idAssoc;
        this.status = status;
        this.createdat = createdat;
        this.updatedAt = updatedAt;
    }

    public Commentaire(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAssoc() {
        return idAssoc;
    }

    public void setIdAssoc(int idAssoc) {
        this.idAssoc = idAssoc;
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
                ", idAssoc=" + idAssoc +
                ", status=" + status +
                ", createdat=" + createdat +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
