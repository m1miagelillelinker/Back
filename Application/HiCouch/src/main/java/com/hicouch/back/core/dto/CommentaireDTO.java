package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Commentaire;

public class CommentaireDTO {
	
	private AssociationDTO association;
	private UserDTO auteur;
	private Commentaire commentaire;

	public CommentaireDTO(AssociationDTO association, UserDTO auteur, Commentaire commentaire) {
		this.association = association;
		this.auteur = auteur;
		this.commentaire = commentaire;
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

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
}
