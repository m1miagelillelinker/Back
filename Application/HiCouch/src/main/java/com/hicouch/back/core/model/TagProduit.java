package com.hicouch.back.core.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="tag_produit")
public class TagProduit {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	
	@Column(name="idproduit")
	String idProduit;
	
	@Column(name="idtag")
	int idTag;
	
    @Column(name="createdat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	

	/**
	 * @param idProduit
	 * @param idTag
	 * @param createdat
	 * @param updatedAt
	 */
	public TagProduit(String idProduit, int idTag, Date createdat, Date updatedAt) {
		this.idProduit = idProduit;
		this.idTag = idTag;
		this.createdat = createdat;
		this.updatedAt = updatedAt;
	}

	public TagProduit() {}

	/**
	 * @return the idProduit
	 */
	public String getIdProduit() {
		return idProduit;
	}

	/**
	 * @return the idTag
	 */
	public int getIdTag() {
		return idTag;
	}

	/**
	 * @return the createdat
	 */
	public Date getCreatedat() {
		return createdat;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @param idTag the idTag to set
	 */
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	/**
	 * @param createdat the createdat to set
	 */
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
	
}
