package com.hicouch.back.core.dto;

import java.time.LocalDateTime;

import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignalementDTO {
	
	private int id;
	private String message;
	private User reporter;
	private int status;
	private User moderator;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private User signaledUser;
	private Commentaire signaledComment;
	
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getModerator() {
		return moderator;
	}

	public void setModerator(User moderator) {
		this.moderator = moderator;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getSignaledUser() {
		return signaledUser;
	}

	public void setSignaledUser(User signaledUser) {
		this.signaledUser = signaledUser;
	}

	public Commentaire getSignaledComment() {
		return signaledComment;
	}

	public void setSignaledComment(Commentaire signaledComment) {
		this.signaledComment = signaledComment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
