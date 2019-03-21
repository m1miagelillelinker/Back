package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer gender;
    private String email;
    private String type_user;
    private Date create_at;
    private Date update_at;
    private String pseudo;
    private Integer score;
    private String password;
    private Boolean id_status;

    public User(Integer id, String firstName, String lastName, Integer gender, String email, String type_user, Date create_at, Date update_at, String pseudo, Integer score, String password, Boolean id_status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.type_user = type_user;
        this.create_at = create_at;
        this.update_at = update_at;
        this.pseudo = pseudo;
        this.score = score;
        this.password = password;
        this.id_status = id_status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", type_user='" + type_user + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", pseudo='" + pseudo + '\'' +
                ", score=" + score +
                ", password='" + password + '\'' +
                ", id_status=" + id_status +
                '}';
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

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
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

    public Boolean getId_status() {
        return id_status;
    }

    public void setId_status(Boolean id_status) {
        this.id_status = id_status;
    }
}
