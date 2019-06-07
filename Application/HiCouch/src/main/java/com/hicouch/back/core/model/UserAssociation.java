package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="userassociation")
public class UserAssociation {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int idUserAssociation;
	
	@Column(name="iduser")
    int idUser;

    @Column(name="idasso")
    String idAsso;

    @CreatedDate
    @Column(name="createat")
    LocalDateTime createdat;

    @LastModifiedDate
    @Column(name="updatedat")
    LocalDateTime updatedAt;
    
	/**
	 * @param idUser
	 * @param idAsso
	 * @param createdat
	 * @param updatedAt
	 */
	public UserAssociation(int idUser, String idAsso, LocalDateTime createdat, LocalDateTime updatedAt) {
		this.idUser = idUser;
		this.idAsso = idAsso;
		this.createdat = createdat;
		this.updatedAt = updatedAt;
	}
	
	public UserAssociation(){}

	/**
	 * @return the idUserAssociation
	 */
	public int getIdUserAssociation() {
		return idUserAssociation;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @return the idAsso
	 */
	public String getIdAsso() {
		return idAsso;
	}

	/**
	 * @return the createdat
	 */
	public LocalDateTime getCreatedat() {
		return createdat;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param idUserAssociation the idUserAssociation to set
	 */
	public void setIdUserAssociation(int idUserAssociation) {
		this.idUserAssociation = idUserAssociation;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @param idAsso the idAsso to set
	 */
	public void setIdAsso(String idAsso) {
		this.idAsso = idAsso;
	}

	/**
	 * @param createdat the createdat to set
	 */
	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
}
