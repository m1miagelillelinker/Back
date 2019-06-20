package com.hicouch.back.core.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "idFollow")
    private Integer idFollow;

    @Column(name = "idAsso")
    private Integer idAsso;

    @Column(name = "type")
    private String type;

    @CreatedDate
    @Column(name="createdat")
    private LocalDateTime createdAt;


    public Historique() {}

    public Historique(Integer idUser, Integer idFollow, Integer idAsso, String type, LocalDateTime createdAt) {
        this.idUser = idUser;
        this.idFollow = idFollow;
        this.idAsso = idAsso;
        this.type = type;
        this.createdAt = createdAt;
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

    public Integer getIdFollow() {
        return idFollow;
    }

    public void setIdFollow(Integer idFollow) {
        this.idFollow = idFollow;
    }

    public Integer getIdAsso() {
        return idAsso;
    }

    public void setIdAsso(Integer idAsso) {
        this.idAsso = idAsso;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idFollow=" + idFollow +
                ", idAsso=" + idAsso +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
