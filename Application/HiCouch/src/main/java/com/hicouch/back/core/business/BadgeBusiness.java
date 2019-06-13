package com.hicouch.back.core.business;

import com.hicouch.back.core.model.Badge;

import java.util.List;

public interface BadgeBusiness {

    List<Badge> getUserBadges(Integer iduser);
}
