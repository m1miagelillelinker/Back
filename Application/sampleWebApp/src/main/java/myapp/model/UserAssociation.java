package myapp.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="userassociation")
public class UserAssociation {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int idUserAssociation;
	
	@Column(name="iduser")
    String idUser;

    @Column(name="idasso")
    String idAsso;

    @Column(name="createat")
    Date createdat;

    @Column(name="updatedat")
    Date updatedAt;
    
	/**
	 * @param idUser
	 * @param idAsso
	 * @param createdat
	 * @param updatedAt
	 */
	public UserAssociation(String idUser, String idAsso, Date createdat, Date updatedAt) {
		this.idUser = idUser;
		this.idAsso = idAsso;
		this.createdat = createdat;
		this.updatedAt = updatedAt;
	}
	
	public UserAssociation(){}

	/**
	 * @return the idUserAssociation
	 */
	public int getIdUserAssociation() {
		return idUserAssociation;
	}

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @return the idAsso
	 */
	public String getIdAsso() {
		return idAsso;
	}

	/**
	 * @return the createdat
	 */
	public Date getCreatedat() {
		return createdat;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param idUserAssociation the idUserAssociation to set
	 */
	public void setIdUserAssociation(int idUserAssociation) {
		this.idUserAssociation = idUserAssociation;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/**
	 * @param idAsso the idAsso to set
	 */
	public void setIdAsso(String idAsso) {
		this.idAsso = idAsso;
	}

	/**
	 * @param createdat the createdat to set
	 */
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
}
