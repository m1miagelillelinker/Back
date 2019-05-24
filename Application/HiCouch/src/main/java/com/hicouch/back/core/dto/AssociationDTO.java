package com.hicouch.back.core.dto;

import java.util.List;

import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;

public class AssociationDTO {

	private Association association;
	private ProductDTO productA;
	private ProductDTO productB;
	private Vote vote;
	private int note;

	/**
	 * @param productA, productB
	 * @param vote
	 * @param commentaires
	 */
	public AssociationDTO(Association association, ProductDTO productA, ProductDTO productB, Vote vote, List<Commentaire> commentaires, int note) {
		super();
		this.association = association;
		this.productA = productA;
		this.productB = productB;
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
	public ProductDTO getProductA() {
		return productA;
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
	public void setProductA(ProductDTO dto) {
		this.productA = dto;
	}

	/**
	 * @param vote
	 *            the vote to set
	 */
	public void setVote(Vote vote) {
		this.vote = vote;
	}


	public ProductDTO getProductB() {
		return productB;
	}

	public void setProductB(ProductDTO productB) {
		this.productB = productB;
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
