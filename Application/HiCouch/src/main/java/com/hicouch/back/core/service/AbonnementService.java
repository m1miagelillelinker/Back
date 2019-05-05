package com.hicouch.back.core.service;

import java.util.List;

import com.hicouch.back.core.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(int userId);
	
	List<Abonnement> getFollowsByFollower(int userId);
	
	Abonnement follow(Integer follower, Integer follows);
	
	void unfollow(Integer follower, Integer follows);
}
