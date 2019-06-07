package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="badges_user")
public class BadgeUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	int id;
	
	@Column(name="iduser")
	int idUser;
	
	@Column(name="idbadge")
	int idBadge;

	@CreatedDate
    @Column(name="createat")
    LocalDateTime createdat;

	@LastModifiedDate
    @Column(name="updatedat")
    LocalDateTime updatedAt;
    
    

	/**
	 * @param idUser
	 * @param idBadge
	 * @param createdat
	 * @param updatedAt
	 */
	public BadgeUser(int idUser, int idBadge, LocalDateTime createdat, LocalDateTime updatedAt) {
		this.idUser = idUser;
		this.idBadge = idBadge;
		this.createdat = createdat;
		this.updatedAt = updatedAt;
	}
	
	public BadgeUser(){}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @return the idBadge
	 */
	public int getIdBadge() {
		return idBadge;
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @param idBadge the idBadge to set
	 */
	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
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
