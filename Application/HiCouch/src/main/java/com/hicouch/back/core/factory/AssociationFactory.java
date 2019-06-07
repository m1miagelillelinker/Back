package com.hicouch.back.core.factory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.VoteService;

@Component
public class AssociationFactory {
	
	private VoteService voteService;
	private ProduitBusiness produitBusiness;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public AssociationFactory(VoteService voteService, ProduitBusiness produitBusiness) {
		this.voteService = voteService;
		this.produitBusiness = produitBusiness;
	}
	
	public AssociationDTO getAssociationDTO(Association association) {
		AssociationDTO associationDTO = new AssociationDTO();
		associationDTO.setAssociation(association);
		
		try {
			ProductDTO productDTOA = produitBusiness.getCompleteProduct(association.getIdproduitA(), association.getIdfournA());
			ProductDTO productDTOB = produitBusiness.getCompleteProduct(association.getIdproduitB(), association.getIdfournB());
			associationDTO.setProductA(productDTOA);
			associationDTO.setProductB(productDTOB);
			// TODO : fetch user
			Vote vote = voteService.getVoteByUserOnAsso(1, association.getId());
			associationDTO.setVote(vote);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return associationDTO;
	}
	
}
