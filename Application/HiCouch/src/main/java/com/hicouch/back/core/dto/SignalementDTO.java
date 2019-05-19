package com.hicouch.back.core.dto;

import java.util.Date;

import com.hicouch.back.core.model.Commentaire;
import com.hicouch.back.core.model.User;

public class SignalementDTO {
	
	private int id;
	private String message;
	private User reporter;
	private int status;
	private User moderator;
	private Date createdAt;
	private Date updatedAt;
	
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
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