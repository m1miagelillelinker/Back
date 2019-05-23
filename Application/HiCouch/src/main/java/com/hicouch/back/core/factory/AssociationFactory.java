package com.hicouch.back.core.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.exception.NoResultException;
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
	
	private ProduitBusiness produitBusiness;
	
	@Autowired
	public AssociationFactory(VoteService voteService, CommentaireService commentaireService, ProduitBusiness produitBusiness) {
		this.voteService = voteService;
		this.commentaireService = commentaireService;
		this.produitBusiness = produitBusiness;
	}
	
	public AssociationDTO getAssociationDTO(Association association) {
		AssociationDTO associationDTO = new AssociationDTO();
		associationDTO.setAssociation(association);
		
		try {
			ProductDTO productDTO = produitBusiness.getCompleteProduct(association.getIdproduitB(), association.getIdfournB());
			associationDTO.setProduct(productDTO);
			// TODO : fetch user
			Vote vote = voteService.getVoteByUserOnAsso(1, association.getId());
			associationDTO.setVote(vote);
			
			List<Commentaire> commentaires = commentaireService.getCommentaireByAsso(association.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return associationDTO;
	}
	
}
