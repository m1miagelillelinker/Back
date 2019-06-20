package com.hicouch.back.core.dto;

import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoriqueDTO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private User user;
    private Historique historique;

    public HistoriqueDTO(User user, Historique historique) {
        this.user = user;
        this.historique = historique;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Historique getHistorique() {
        return historique;
    }

    public void setHistorique(Historique historique) {
        this.historique = historique;
    }

    @Override
    public String toString() {
        return "HistoriqueDTO{" +
                "user=" + user +
                ", historique=" + historique +
                '}';
    }
}
