package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoriqueDTO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String username;
    private Integer userId;
    
    // abonnement
    private String followUserName;
    private Integer followId;
    
    // asso - commentaire
    private String idProduitA;
    private String nomProduitA;
    private String idTypeProduitA;
    
    private String idProduitB;
    private String nomProduitB;
    private String idTypeProduitB;
    
    
    private Historique historique;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFollowUserName() {
		return followUserName;
	}


	public void setFollowUserName(String followUserName) {
		this.followUserName = followUserName;
	}


	public Integer getFollowId() {
		return followId;
	}


	public void setFollowId(Integer followId) {
		this.followId = followId;
	}


	public String getIdProduitA() {
		return idProduitA;
	}


	public void setIdProduitA(String idProduitA) {
		this.idProduitA = idProduitA;
	}


	public String getNomProduitA() {
		return nomProduitA;
	}


	public void setNomProduitA(String nomProduitA) {
		this.nomProduitA = nomProduitA;
	}


	public String getIdTypeProduitA() {
		return idTypeProduitA;
	}


	public void setIdTypeProduitA(String idTypeProduitA) {
		this.idTypeProduitA = idTypeProduitA;
	}


	public String getIdProduitB() {
		return idProduitB;
	}


	public void setIdProduitB(String idProduitB) {
		this.idProduitB = idProduitB;
	}


	public String getNomProduitB() {
		return nomProduitB;
	}


	public void setNomProduitB(String nomProduitB) {
		this.nomProduitB = nomProduitB;
	}


	public String getIdTypeProduitB() {
		return idTypeProduitB;
	}


	public void setIdTypeProduitB(String idTypeProduitB) {
		this.idTypeProduitB = idTypeProduitB;
	}


	public Historique getHistorique() {
		return historique;
	}


	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
    
    
	
    
}
