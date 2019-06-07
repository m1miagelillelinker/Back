package com.hicouch.back.core.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.Signalement;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.CommentaireService;
import com.hicouch.back.core.service.UserService;

@Component
public class SignalementFactory {

	private UserService userService;
	private CommentaireService commentaireService;

	@Autowired
	public SignalementFactory(UserService userService, CommentaireService commentaireService) {
		super();
		this.userService = userService;
		this.commentaireService = commentaireService;
	}

	public SignalementDTO getSignalementDTO(Signalement signalement) {
		SignalementDTO signalementDTO = new SignalementDTO();

		signalementDTO.setId(signalement.getId());
		signalementDTO.setCreatedAt(signalement.getCreatedat());
		signalementDTO.setUpdatedAt(signalement.getUpdatedAt());
		signalementDTO.setMessage(signalement.getMessage());
		signalementDTO.setStatus(signalement.getStatus());

		try {
			User reporter = userService.getUserById(signalement.getIdUser());
			signalementDTO.setReporter(reporter);
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		if (signalement.getModeratorId() != null) {
			try {

				User moderator = userService.getUserById(signalement.getModeratorId());
				signalementDTO.setModerator(moderator);

			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}
		
		if (signalement.getSignaledCommentId() != null) {
			try {
				Commentaire comment = commentaireService.findById(signalement.getSignaledCommentId());
				signalementDTO.setSignaledComment(comment);
			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}

		if (signalement.getSignaledUserId() != null) {
			try {
				User user = userService.getUserById(signalement.getSignaledUserId());
				System.out.println(user.toString());
				signalementDTO.setSignaledUser(user);
			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}

		return signalementDTO;
	}

}
