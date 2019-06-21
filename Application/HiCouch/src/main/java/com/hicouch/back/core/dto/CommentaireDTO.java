package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentaireDTO {
	
	private AssociationDTO association;
	private UserDTO auteur;
	private Commentaire commentaire;
	private Vote vote;
	private boolean owned;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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

	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	
	
}
