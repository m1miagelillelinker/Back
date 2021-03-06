package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.repository.AbonnementRepository;
import com.hicouch.back.core.service.AbonnementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService {

    private final AbonnementRepository abonnementRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AbonnementServiceImpl(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }
    
    @Override
    public List<Abonnement> getFollowersByFollows(int userId) {
    	return abonnementRepository.findAllByFollows(userId);
    }

	@Override
	public List<Abonnement> getFollowsByFollower(int userId) {
        return abonnementRepository.findAllByFollower(userId);
	}

	@Override
	public Abonnement follow(Integer follower, Integer follows) {
		Abonnement abonnement = new Abonnement(follower, follows, LocalDateTime.now(), LocalDateTime.now());
		return abonnementRepository.save(abonnement);
	}

	@Override
	public void unfollow(Integer follower, Integer follows) {
		Abonnement abonnement = abonnementRepository.findByFollowerAndFollows(follower, follows).get();
		abonnementRepository.delete(abonnement);
		
	}

}
