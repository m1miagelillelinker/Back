package com.hicouch.back.core.model;

import com.hicouch.back.core.enumeration.StatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="Commentaire")
    private String commentaire;

    @Column(name="Note")
    private Integer note = 0;

    @Column(name="iduser")
    private int idUser;

    @Column(name="idpair")
    private int idPair;

    @Column(name="status")
    private int status;

    @Column(name="createdat")
    private Date createdat = new Date();

    @Column(name="updatedat")
    private Date updatedAt;

    public Commentaire(String commentaire, int idUser, int idPair) {
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPair = idPair;
        this.status = StatusEnum.TO_MODERATE;
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
