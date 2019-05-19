package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.SignalementBusiness;
import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.enumeration.SignalementTypeEnum;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.SignalementFactory;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.SignalementService;
import com.hicouch.back.core.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalementBusinessImpl implements SignalementBusiness {
	
	private CommentaireService commentaireService;
	private UserService userService;
	private SignalementService signalementService;
	private SignalementFactory signalementFactory;
	
	@Autowired
	public SignalementBusinessImpl(CommentaireService commentaireService, UserService userService,
			SignalementService signalementService, SignalementFactory signalementFactory) {
		super();
		this.commentaireService = commentaireService;
		this.userService = userService;
		this.signalementService = signalementService;
		this.signalementFactory = signalementFactory;
	}

	@Override
	public SignalementDTO processSignalement(int signalementId, int status) throws NoResultException {
		// TODO Auto-generated method stub
		Signalement signalement = signalementService.getSignalementById(signalementId);
		
		switch(signalement.getTypeSignalement()) {
		case SignalementTypeEnum.COMMENTAIRE:
			commentaireService.setCommentaireStatus(signalement.getSignaledCommentId(), status);
			break;
		case SignalementTypeEnum.UTILISATEUR:
			userService.setUserStatus(signalement.getSignaledUserId(), status);
			break;
		default:
			break;
		}
		
		signalementService.setSignalementStatus(signalementId, status);
		
		return signalementFactory.getSignalementDTO(signalement);
	}
}
