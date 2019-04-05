package myapp.model;

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

    @Column(name="id_user")
    int id_user;

    @Column(name="id_assoc")
    int id_assoc;

    @Column(name="status")
    int status;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;

    public Commentaire(){}

    public Commentaire(String commentaire, int note, int id_user, int id_assoc, int status, Date created_at, Date updated_at) {
        this.commentaire = commentaire;
        this.note = note;
        this.id_user = id_user;
        this.id_assoc = id_assoc;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_assoc() {
        return id_assoc;
    }

    public void setId_assoc(int id_assoc) {
        this.id_assoc = id_assoc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", id_user=" + id_user +
                ", id_assoc=" + id_assoc +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
