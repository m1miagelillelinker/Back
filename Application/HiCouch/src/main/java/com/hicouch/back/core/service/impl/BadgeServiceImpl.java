package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.Badge;
import com.hicouch.back.core.repository.BadgeRepository;
import com.hicouch.back.core.service.BadgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public BadgeServiceImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<Badge> findAll() {
        return badgeRepository.findAll();
    }
}
