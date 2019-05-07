package com.hicouch.back.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="association")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="idproduitA")
    String idproduitA;
    
    @Column(name="idfournA")
    String idfournA;

    @Column(name="idproduitB")
    String idproduitB;
    
    @Column(name="idfournB")
    String idfournB;
    
    @Column(name="idpair")
    Integer idPair;

    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedat;

    public Association(){}

    public Association(String idproduitA, String idfournA, String idproduitB, String idfournB, int idPair, Date createdat, Date updatedat) {
        this.idproduitA = idproduitA;
        this.idfournA = idfournA;
        this.idproduitB = idproduitB;
        this.idfournB = idfournB;
        this.idPair = idPair;
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

	/**
	 * @return the idPair
	 */
	public Integer getIdPair() {
		return idPair;
	}

	/**
	 * @param idPair the idPair to set
	 */
	public void setIdPair(Integer idPair) {
		this.idPair = idPair;
	}

	/**
	 * @return the idfournA
	 */
	public String getIdfournA() {
		return idfournA;
	}

	/**
	 * @return the idfournB
	 */
	public String getIdfournB() {
		return idfournB;
	}

	/**
	 * @param idfournA the idfournA to set
	 */
	public void setIdfournA(String idfournA) {
		this.idfournA = idfournA;
	}

	/**
	 * @param idfournB the idfournB to set
	 */
	public void setIdfournB(String idfournB) {
		this.idfournB = idfournB;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Association [id=" + id + ", idproduitA=" + idproduitA + ", idfournA=" + idfournA + ", idproduitB="
				+ idproduitB + ", idfournB=" + idfournB + ", idPair=" + idPair + ", createdat=" + createdat
				+ ", updatedat=" + updatedat + "]";
	}
}
