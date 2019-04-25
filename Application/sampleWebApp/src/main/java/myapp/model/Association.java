package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="association_produit")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_assoc")
    String id;

    @Column(name="id_produit_A")
    String id_produit_A;

    @Column(name="id_produit_B")
    String id_produit_B;

    @Column(name="created_at")
    Date created_at;

    @Column(name="updated_at")
    Date updated_at;


    public Association(String id_produit_A, String id_produit_B, Date created_at, Date updated_at) {
        this.id_produit_A = id_produit_A;
        this.id_produit_B = id_produit_B;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Association(){}

    public String getId_produit_A() {
        return id_produit_A;
    }

    public void setId_produit_A(String id_produit_A) {
        this.id_produit_A = id_produit_A;
    }

    public String getId_produit_B() {
        return id_produit_B;
    }

    public void setId_produit_B(String id_produit_B) {
        this.id_produit_B = id_produit_B;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id='" + id + '\'' +
                ", id_produit_A='" + id_produit_A + '\'' +
                ", id_produit_B='" + id_produit_B + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
