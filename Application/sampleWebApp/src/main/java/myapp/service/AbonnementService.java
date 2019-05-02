package myapp.service;

import java.util.List;

import myapp.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(String userId);
	
	List<Abonnement> getFollowsByFollower(String userId);
	
	Abonnement follow(Integer follower, Integer follows);
	
	void unfollow(Integer follower, Integer follows);
}
