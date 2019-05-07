package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.AbonnementRepository;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.service.AbonnementService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonnementServiceImpl implements AbonnementService {

    private final AbonnementRepository abonnementRepository;

    @Autowired
    public AbonnementServiceImpl(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }
    
    @Override
    public List<Abonnement> getFollowersByFollows(int userId) {
        Optional<List<Abonnement>> rep = abonnementRepository.findAllByFollower(userId);
        System.out.println("test getFollowersById :"+rep.toString());
        return rep.get();
    }

	@Override
	public List<Abonnement> getFollowsByFollower(int userId) {
        Optional<List<Abonnement>> rep = abonnementRepository.findAllByFollows(userId);
        System.out.println("test getFollowersById :"+rep.toString());
        return rep.get();
	}

	@Override
	public Abonnement follow(Integer follower, Integer follows) {
		Abonnement abonnement = new Abonnement(follower, follows, new Date(), new Date());
		return abonnementRepository.save(abonnement);
	}

	@Override
	public void unfollow(Integer follower, Integer follows) {
		Abonnement abonnement = abonnementRepository.findByFollowerAndFollows(follower, follows).get();
		abonnementRepository.delete(abonnement);
		
	}

}