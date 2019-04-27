package myapp.model;


import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idabonnement")
    int idAbonnement;
	
    @Column(name="follower")
    String follower;

    @Column(name="follows")
    String follows;

    @Column(name="createdat")
    Date createdAt;

    @Column(name="updatedat")
    Date updatedAt;

    public Abonnement(String follower, String follows, Date createdAt, Date updatedAt) {
    	this.follower = follower;
        this.follows = follows;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Abonnement(){}

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "follower=" + follower +
                ", follows=" + follows +
                ", created_at=" + createdAt +
                ", updated_at=" + updatedAt +
                '}';
    }
}
