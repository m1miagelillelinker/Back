package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="badge")
    String description;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;

    public Badge(){}

    public Badge(String description, Date created_at, Date updated_at) {
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Badge{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
