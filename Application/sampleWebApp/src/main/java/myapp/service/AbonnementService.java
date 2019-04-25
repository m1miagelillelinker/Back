package myapp.service;

import java.util.List;

import myapp.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(String userId);
	
	List<Abonnement> getFollowsByFollower(String userId);
	
	Abonnement follow(String follower, String follows);
	
	void unfollow(String follower, String follows);
}
