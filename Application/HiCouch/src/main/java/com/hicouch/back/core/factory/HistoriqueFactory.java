package com.hicouch.back.core.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hicouch.back.core.dto.CommentaireDTO;
import com.hicouch.back.core.dto.HistoriqueDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.UserService;

public class HistoriqueFactory {
	
	private UserService userService;
    private AssociationService associationService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HistoriqueFactory(UserService userService, AssociationService associationService) {
        super();
        this.userService        = userService;
        this.associationService = associationService;
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
        
        
        
        return historiqueDTO;
   
    }

    public List<HistoriqueDTO> convertCommentaires(List<Historique> historiques){
        return historiques.stream().map(this::getHistoriqueDTO).collect(Collectors.toList());
    }

}
