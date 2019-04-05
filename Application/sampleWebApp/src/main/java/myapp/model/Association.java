package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="association")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="visible")
    int visible;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;


    public Association(){}

    public Association(int visible, Date created_at, Date updated_at) {
        this.visible = visible;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
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
        return "Association{" +
                "id=" + id +
                ", visible=" + visible +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
