package com.hicouch.back.core.service;

import com.hicouch.back.core.model.Abonnement;

import java.util.List;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(int userId);
	
	List<Abonnement> getFollowsByFollower(int userId);
	
	Abonnement follow(Integer follower, Integer follows);
	
	void unfollow(Integer follower, Integer follows);
}
