package com.hicouch.back.core.business;

import com.hicouch.back.core.model.Abonnement;

public interface AbonnementBusiness {
    Abonnement follow(Integer follower, Integer follows);
}
