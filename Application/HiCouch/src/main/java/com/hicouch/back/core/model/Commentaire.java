package com.hicouch.back.core.model;

import com.hicouch.back.core.enumeration.StatusEnum;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="commentaire")
    private String commentaire;

    @Column(name="note")
    private Integer note = 0;

    @Column(name="iduser")
    private int idUser;

    @Column(name="idpair")
    private int idPair;

    @Column(name="status")
    private int status;

    @CreatedDate
    @Column(name="createdat",columnDefinition="datetime")
    private LocalDateTime createdat;

    @LastModifiedDate
    @Column(name="updatedat",columnDefinition="datetime")
    private LocalDateTime updatedAt;

    public Commentaire(String commentaire, int idUser, int idPair) {
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPair = idPair;
        this.status = StatusEnum.OK;
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
