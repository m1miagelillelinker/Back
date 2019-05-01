package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="commentaire")
public class Signalement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="typeSignalement")
    String typeSignalement;

    @Column(name="signaledUserId")
    int signaledUserId;

    @Column(name="signaledCommentId")
    int signaledCommentId;

    @Column(name="message")
    String message;

    @Column(name="iduser")
    int idUser;

    @Column(name="status")
    int status;

    @Column(name="moderatorId")
    int moderatorId;

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    //Signalement full
    public Signalement(String typeSignalement, int signaledId, String message, int idUser, int status, int moderatorId, Date createdat, Date updatedAt) {
        this.typeSignalement = typeSignalement;
        switch (typeSignalement){
            case "utilisateur":
                this.signaledUserId = signaledId;
                this.signaledCommentId = 0;
                break;
            case "comment":
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
    public Signalement(String typeSignalement, int signaledId, String message, int idUser, int moderatorId) {
        //appel du constructeur principal
        this(typeSignalement, signaledId, message, idUser, 1, moderatorId, new Date(), new Date());
    }

    public Signalement(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeSignalement() {
        return typeSignalement;
    }

    public void setTypeSignalement(String typeSignalement) {
        this.typeSignalement = typeSignalement;
    }

    public int getSignaledUserId() {
        return signaledUserId;
    }

    public void setSignaledUserId(int signaledUserId) {
        this.signaledUserId = signaledUserId;
    }

    public int getSignaledCommentId() {
        return signaledCommentId;
    }

    public void setSignaledCommentId(int signaledCommentId) {
        this.signaledCommentId = signaledCommentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(int moderatorId) {
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
