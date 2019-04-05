package myapp.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="follower")
    int follower;

    @Column(name="follows")
    int follows;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;

    public Abonnement(int follows, Date created_at, Date updated_at) {
        this.follows = follows;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Abonnement(){}

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
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
