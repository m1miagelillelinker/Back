package com.hicouch.back.core.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="historique")
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "evenements")
    private List<String> evenements;

    public Historique() {
    }

    public Historique(Integer idUser, String pseudo, List<String> evenements) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.evenements = evenements;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<String> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<String> evenements) {
        this.evenements = evenements;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", pseudo='" + pseudo + '\'' +
                ", evenements=" + evenements +
                '}';
    }
}
