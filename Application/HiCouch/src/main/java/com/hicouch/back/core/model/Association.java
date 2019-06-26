package com.hicouch.back.core.model;

import com.hicouch.back.core.enumeration.StatusEnum;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="association")
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "note")
    Integer note;

    @CreatedDate
    @Column(name="createdat")
    LocalDateTime createdat;

    @LastModifiedDate
    @Column(name="updatedat")
    LocalDateTime updatedat;

    @Column(name="iduser")
    private Integer idUser;

    @Column(name = "status")
    private Integer status;

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String modificator;


    public Association(){}

    public Association(String idproduitA, String idfournA, String idproduitB, String idfournB, int idPair, LocalDateTime createdat, LocalDateTime updatedat) {
        this.idproduitA = idproduitA;
        this.idfournA = idfournA;
        this.idproduitB = idproduitB;
        this.idfournB = idfournB;
        this.idPair = idPair;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.note=0;
    }

    public Association(String idproduitA, String idfournA, String idproduitB, String idfournB, int idPair, Integer iduser) {
        this.idproduitA = idproduitA;
        this.idfournA = idfournA;
        this.idproduitB = idproduitB;
        this.idfournB = idfournB;
        this.idPair = idPair;
        this.status = StatusEnum.OK;
        this.createdat = LocalDateTime.now();
        this.updatedat = LocalDateTime.now();
        this.creator = iduser.toString();
        this.modificator = iduser.toString();
        this.idUser = iduser;
        this.note = 0;
    }

    public Integer getId() {
        return id;
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

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    public Integer getStatus() { return status;  }

    public void setStatus(Integer status) { this.status = status; }

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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Association(String idproduitA, String idfournA, String idproduitB, String idfournB, Integer idPair, Integer note, LocalDateTime createdat, LocalDateTime updatedat, String creator, String modificator, Integer idUser) {
        this.idproduitA = idproduitA;
        this.idfournA = idfournA;
        this.idproduitB = idproduitB;
        this.idfournB = idfournB;
        this.idPair = idPair;
        this.note = note;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.creator = creator;
        this.modificator = modificator;
        this.idUser = idUser;
    }
}
