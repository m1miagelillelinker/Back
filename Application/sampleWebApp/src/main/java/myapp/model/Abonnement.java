package myapp.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idabonnement")
    int idabonnement;

    @Column(name="follower")
    int follower;

    @Column(name="follows")
    int follows;

    @Column(name="createat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

    public Abonnement(int follower, int follows, Date createdat, Date updatedAt) {
        this.follower = follower;
        this.follows = follows;
        this.createdat = createdat;
        this.updatedAt = updatedAt;
    }

    public Abonnement(){}

    public int getIdabonnement() {
        return idabonnement;
    }

    public void setIdabonnement(int idabonnement) {
        this.idabonnement = idabonnement;
    }

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
        return "Abonnement{" +
                "idabonnement=" + idabonnement +
                ", follower='" + follower + '\'' +
                ", follows='" + follows + '\'' +
                ", createdat=" + createdat +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
