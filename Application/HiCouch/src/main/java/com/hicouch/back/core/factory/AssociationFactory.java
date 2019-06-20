package com.hicouch.back.core.factory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hicouch.back.core.business.ProduitBusiness;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.ProductDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.model.Vote;
import com.hicouch.back.core.service.UserService;
import com.hicouch.back.core.service.VoteService;

@Component
public class AssociationFactory {
	
	private VoteService voteService;
	private UserService userService;
	private ProduitBusiness produitBusiness;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public AssociationFactory(VoteService voteService, UserService userService, ProduitBusiness produitBusiness) {
		this.voteService = voteService;
		this.userService = userService;
		this.produitBusiness = produitBusiness;
	}
	
	public AssociationDTO getAssociationDTO(Association association) {
		AssociationDTO associationDTO = new AssociationDTO();
		associationDTO.setAssociation(association);
		User u = null;
		
		try {
			u = userService.getCurrentUser();
			
			ProductDTO productDTOA = produitBusiness.getCompleteProduct(association.getIdproduitA(), association.getIdfournA());
			ProductDTO productDTOB = produitBusiness.getCompleteProduct(association.getIdproduitB(), association.getIdfournB());
			associationDTO.setProductA(productDTOA);
			associationDTO.setProductB(productDTOB);

			try{
				Vote vote = voteService.getVoteByUserOnAsso(u.getId(), association.getId());
				associationDTO.setVote(vote);
			} catch (NoResultException e){
				logger.info("No vote: " + e.getMessage());
			}
		} catch (BusinessException e) {
			logger.warn("Erreur lors de la construction de l'association " + association.getId()
				+ " avec l'utilisateur " + (u != null ? u.getId() : "Anonyme"));
			e.printStackTrace();
		}
		
		return associationDTO;
	}
	
}
