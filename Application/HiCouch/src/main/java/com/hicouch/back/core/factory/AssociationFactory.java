package com.hicouch.back.core.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.service.VoteService;

@Component
public class AssociationFactory {
	
	private VoteService voteService;

	private CommentaireService commentaireService;
	
	private ProduitService productService;
	
	@Autowired
	public AssociationFactory(VoteService voteService, CommentaireService commentaireService, ProduitService productService) {
		this.voteService = voteService;
		this.commentaireService = commentaireService;
		this.productService = productService;
	}
	
	public AssociationDTO getAssociationDTO(Association association) {
		AssociationDTO associationDTO = new AssociationDTO();
		ProductDTO productDTO = null;
		
		try {
			productDTO = productService.getProductByIdFromReferentiel(association.getIdproduitB(), association.getIdfournB());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO : get user id
		Vote vote = voteService.getVoteByUserOnAsso(1, association.getId());
		List<Commentaire> commentaires = commentaireService.getCommentaireByAsso(association.getId());
		
		associationDTO.setProductDTO(productDTO);
		associationDTO.setCommentaires(commentaires);
		associationDTO.setVote(vote);
		
		return associationDTO;
	}
	
}
