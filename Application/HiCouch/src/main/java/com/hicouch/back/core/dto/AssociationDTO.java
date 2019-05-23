package com.hicouch.back.core.dto;

import java.util.List;

import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;

public class AssociationDTO {

	private Association association;
	private ProductDTO product;
	private Vote vote;
	private int note;

	/**
	 * @param dto
	 * @param vote
	 * @param commentaires
	 */
	public AssociationDTO(Association association, ProductDTO dto, Vote vote, List<Commentaire> commentaires, int note) {
		super();
		this.association = association;
		this.product = dto;
		this.vote = vote;
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
	public ProductDTO getProduct() {
		return product;
	}

	/**
	 * @return the vote
	 */
	public Vote getVote() {
		return vote;
	}

	/**
	 * @param dto
	 *            the dto to set
	 */
	public void setProduct(ProductDTO dto) {
		this.product = dto;
	}

	/**
	 * @param vote
	 *            the vote to set
	 */
	public void setVote(Vote vote) {
		this.vote = vote;
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
