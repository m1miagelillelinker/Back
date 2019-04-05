package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="id_assoc")
    int id_assoc;

    @Column(name="vote")
    int vote;

    @Column(name="id_user")
    int id_user;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;

    public Vote(){}

    public Vote(int id_assoc, int vote, int id_user, Date created_at, Date updated_at) {
        this.id_assoc = id_assoc;
        this.vote = vote;
        this.id_user = id_user;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_assoc() {
        return id_assoc;
    }

    public void setId_assoc(int id_assoc) {
        this.id_assoc = id_assoc;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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


}
