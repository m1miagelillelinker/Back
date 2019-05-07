package com.hicouch.back.core.dto;

import java.util.List;

import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;

public class AssociationDTO {

	private Association association;
	private ProductDTO productDTO;
	private Vote vote;
	private List<Commentaire> commentaires;
	private int note;

	/**
	 * @param dto
	 * @param vote
	 * @param commentaires
	 */
	public AssociationDTO(Association association, ProductDTO dto, Vote vote, List<Commentaire> commentaires, int note) {
		super();
		this.association = association;
		this.productDTO = dto;
		this.vote = vote;
		this.commentaires = commentaires;
		this.note = note;
	}

	/**
	 * 
	 */
	public AssociationDTO() {
		super();
	}

	/**
	 * @return the dto
	 */
	public ProductDTO getProductDTO() {
		return productDTO;
	}

	/**
	 * @return the vote
	 */
	public Vote getVote() {
		return vote;
	}

	/**
	 * @return the commentaires
	 */
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	/**
	 * @param dto
	 *            the dto to set
	 */
	public void setProductDTO(ProductDTO dto) {
		this.productDTO = dto;
	}

	/**
	 * @param vote
	 *            the vote to set
	 */
	public void setVote(Vote vote) {
		this.vote = vote;
	}

	/**
	 * @param commentaires
	 *            the commentaires to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * @return the association
	 */
	public Association getAssociation() {
		return association;
	}

	/**
	 * @param association the association to set
	 */
	public void setAssociation(Association association) {
		this.association = association;
	}

}
