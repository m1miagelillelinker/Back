package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.BadgeRepository;
import com.hicouch.back.core.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;

    @Autowired
    public BadgeServiceImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }
}
