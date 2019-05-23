package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Commentaire;

import java.util.List;

public class CommentaireDTO {
	
	private List<AssociationDTO> associations;
	private UserDTO auteur;
	private Commentaire metaInformation;

	public CommentaireDTO(List<AssociationDTO> associations, UserDTO auteur, Commentaire metaInformation) {
		this.associations = associations;
		this.auteur = auteur;
		this.metaInformation = metaInformation;
	}

	/**
	 *
	 */
	public CommentaireDTO() {
		super();
	}

	public List<AssociationDTO> getAssociations() {
		return associations;
	}

	public void setAssociations(List<AssociationDTO> associations) {
		this.associations = associations;
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
