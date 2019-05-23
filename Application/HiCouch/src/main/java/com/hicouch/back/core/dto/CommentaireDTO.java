package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.User;

import java.util.Date;
import java.util.List;

public class CommentaireDTO {
	
	private AssociationDTO association;
	private UserDTO auteur;
	private Commentaire metaInformation;

	public CommentaireDTO(AssociationDTO association, UserDTO auteur, Commentaire metaInformation) {
		this.association = association;
		this.auteur = auteur;
		this.metaInformation = metaInformation;
	}

	/**
	 *
	 */
	public CommentaireDTO() {
		super();
	}

	public AssociationDTO getAssociation() {
		return association;
	}

	public void setAssociation(AssociationDTO association) {
		this.association = association;
	}

	public UserDTO getAuteur() {
		return auteur;
	}

	public void setAuteur(UserDTO auteur) {
		this.auteur = auteur;
	}

	public Commentaire getMetaInformation() {
		return metaInformation;
	}

	public void setMetaInformation(Commentaire metaInformation) {
		this.metaInformation = metaInformation;
	}
}
