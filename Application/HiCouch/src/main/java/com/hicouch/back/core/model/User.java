package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "email")
	private String email;

	@Column(name = "typeuser")
	private Integer typeUser;

	@Column(name = "pseudo")
	private String pseudo;

	@Column(name = "score")
	private Integer score;

	@Column(name = "password")
	private String password;

	@Column(name = "idstatus")
	private Integer idstatus;

	@Column(name = "picture")
	private String picture;

	@CreatedDate
	@Column(name = "createdat")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updatedat")
	private LocalDateTime updatedAt;

	@Column(name = "lastlogin")
	private LocalDateTime lastlogin;

	@Column(name = "loginscount")
	private Integer loginscount;

	@Column(name = "idauth0")
	private String idAuth0;

	public User(String firstName, String lastName, Integer gender, String email, Integer typeUser, String pseudo,
			Integer score, String password, Integer idstatus, String picture, LocalDateTime createdAt,
			LocalDateTime updatedAt, LocalDateTime lastlogin, Integer loginscount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.typeUser = typeUser;
		this.pseudo = pseudo;
		this.score = score;
		this.password = password;
		this.idstatus = idstatus;
		this.picture = picture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.lastlogin = lastlogin;
		this.loginscount = loginscount;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(Integer typeUser) {
		this.typeUser = typeUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(Integer idstatus) {
		this.idstatus = idstatus;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public LocalDateTime getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Integer getLoginscount() {
		return loginscount;
	}

	public void setLoginscount(Integer loginscount) {
		this.loginscount = loginscount;
	}

	public String getIdAuth0() {
		return idAuth0;
	}

	public void setIdAuth0(String idAuth0) {
		this.idAuth0 = idAuth0;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", typeUser=" + typeUser + ", pseudo=" + pseudo + ", score=" + score
				+ ", password=" + password + ", idstatus=" + idstatus + ", picture=" + picture + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", lastlogin=" + lastlogin + ", loginscount=" + loginscount
				+ ", idAuth0=" + idAuth0 + "]";
	}

}
