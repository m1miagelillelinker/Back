package myapp.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="follower")
    String follower;

    @Id
    @Column(name="follows")
    String follows;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;

    public Abonnement(String follower, String follows, Date created_at, Date updated_at) {
    	this.follower = follower;
        this.follows = follows;
        this.created_at = created_at;
        this.updated_at = updated_at;
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
        return "Abonnement{" +
                "follower=" + follower +
                ", follows=" + follows +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
