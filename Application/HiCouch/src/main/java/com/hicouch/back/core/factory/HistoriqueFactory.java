package com.hicouch.back.core.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.enumeration.HistoriqueTypeEnum;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.UserService;

public class HistoriqueFactory {
	
	private UserService userService;
    private AssociationService associationService;
    private AssociationFactory associationFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HistoriqueFactory(UserService userService, AssociationService associationService, AssociationFactory associationFactory) {
        super();
        this.userService        = userService;
        this.associationService = associationService;
        this.associationFactory = associationFactory;
    }
	
	public HistoriqueDTO getHistoriqueDTO(Historique historique) {
        logger.trace("getHistoriqueDTO");

        HistoriqueDTO historiqueDTO = new HistoriqueDTO();
        historiqueDTO.setHistorique(historique);
        historiqueDTO.setUserId(historique.getIdUser());
        try {
        	historiqueDTO.setUsername(userService.getUserById(historique.getIdUser()).getPseudo());
        } catch (BusinessException e) {
        	logger.error("No result for user " + historique.getIdUser());
        	e.printStackTrace();
        }
        
        switch (historique.getType()) {
		case HistoriqueTypeEnum.ABONNEMENT:
			historiqueDTO.setFollowId(historique.getIdFollow());
			try {
	        	historiqueDTO.setFollowUserName(userService.getUserById(historique.getIdFollow()).getPseudo());
	        } catch (BusinessException e) {
	        	logger.error("No result for user " + historique.getIdFollow());
	        	e.printStackTrace();
	        }
			break;
		case HistoriqueTypeEnum.ASSOCIATION:
		case HistoriqueTypeEnum.COMMENTAIRE:
			AssociationDTO associationDTO = associationService.getAssociationByIdPair(historique.getIdAsso());
			historiqueDTO.setIdProduitA(associationDTO.getProductA().getId());
			historiqueDTO.setIdProduitB(associationDTO.getProductB().getId());
			historiqueDTO.setIdTypeProduitA(associationDTO.getProductA().getType());
			historiqueDTO.setIdTypeProduitB(associationDTO.getProductB().getType());
			historiqueDTO.setNomProduitA(associationDTO.getProductA().getTitle());
			historiqueDTO.setNomProduitB(associationDTO.getProductB().getTitle());
		default:
			break;
		}
        
        return historiqueDTO;
   
    }

    public List<HistoriqueDTO> convertCommentaires(List<Historique> historiques){
        return historiques.stream().map(this::getHistoriqueDTO).collect(Collectors.toList());
    }

}
