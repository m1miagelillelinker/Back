package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="association")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    Integer id;

    @Column(name="idproduitA")
    String idproduitA;

    @Column(name="idproduitB")
    String idproduitB;

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedat;

    public Association(){}

    public Association(String idproduitA, String idproduitB, Date createdat, Date updatedat) {
        this.idproduitA = idproduitA;
        this.idproduitB = idproduitB;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdproduitA() {
        return idproduitA;
    }

    public void setIdproduitA(String idproduitA) {
        this.idproduitA = idproduitA;
    }

    public String getIdproduitB() {
        return idproduitB;
    }

    public void setIdproduitB(String idproduitB) {
        this.idproduitB = idproduitB;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", idproduitA='" + idproduitA + '\'' +
                ", idproduitB='" + idproduitB + '\'' +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                '}';
    }
}
