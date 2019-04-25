package myapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="gender")
    private Integer gender;

    @Column(name="email")
    private String email;

    @Column(name="type_user")
    private String type_user;

    @Column(name="created_at")
    private Date create_at;

    @Column(name="updated_at")
    private Date update_at;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="score")
    private Integer score;

    @Column(name="password")
    private String password;

    @Column(name="id_status")
    private Integer id_status;

    public User(Integer id, String firstName, String lastName, Integer gender, String email, String type_user, Date create_at, Date update_at, String pseudo, Integer score, String password, Integer id_status) {
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

    public User(){
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

    public Integer getId_status() {
        return id_status;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

}
