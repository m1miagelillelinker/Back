package com.hicouch.back.core.model;

import javax.persistence.*;

import com.hicouch.back.core.enumeration.SignalementTypeEnum;

import java.util.Date;

@Entity
@Table(name="signalement")
public class Signalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="typesignalement")
    String typeSignalement;

    @Column(name="signaleduserid")
    Integer signaledUserId;

    @Column(name="signaledcommentid")
    Integer signaledCommentId;

    @Column(name="message")
    String message;

    @Column(name="iduser")
    Integer idUser;

    @Column(name="status")
    Integer status;

    @Column(name="moderatorid")
    Integer moderatorId;

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    //Signalement full
    public Signalement(String typeSignalement, Integer signaledId, String message, Integer idUser, Integer status, Integer moderatorId, Date createdat, Date updatedAt) {
        this.typeSignalement = typeSignalement;
        switch (typeSignalement){
            case SignalementTypeEnum.UTILISATEUR:
                this.signaledUserId = signaledId;
                this.signaledCommentId = 0;
                break;
            case SignalementTypeEnum.COMMENTAIRE:
                this.signaledCommentId = signaledId;
                this.signaledUserId = 0;
                break;
        }
        this.message = message;
        this.idUser = idUser;
        this.status = status;
        this.moderatorId = moderatorId;
        this.createdat = createdat;
        this.updatedAt = updatedAt;
    }

    //Constructeur de création
    public Signalement(String typeSignalement, Integer signaledId, String message, Integer idUser, Integer moderatorId) {
        //appel du constructeur principal
        this(typeSignalement, signaledId, message, idUser, 1, moderatorId, new Date(), new Date());
    }

    public Signalement(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeSignalement() {
        return typeSignalement;
    }

    public void setTypeSignalement(String typeSignalement) {
        this.typeSignalement = typeSignalement;
    }

    public Integer getSignaledUserId() {
        return signaledUserId;
    }

    public void setSignaledUserId(Integer signaledUserId) {
        this.signaledUserId = signaledUserId;
    }

    public Integer getSignaledCommentId() {
        return signaledCommentId;
    }

    public void setSignaledCommentId(Integer signaledCommentId) {
        this.signaledCommentId = signaledCommentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Integer moderatorId) {
        this.moderatorId = moderatorId;
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
        return "Signalement{" +
                "id=" + id +
                ", typeSignalement='" + typeSignalement + '\'' +
                ", signaledUserId=" + signaledUserId +
                ", signaledCommentId=" + signaledCommentId +
                ", message='" + message + '\'' +
                ", idUser=" + idUser +
                ", status=" + status +
                ", moderatorId=" + moderatorId +
                ", createdat=" + createdat +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
