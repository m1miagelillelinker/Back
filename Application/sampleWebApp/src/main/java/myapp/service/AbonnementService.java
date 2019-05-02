package myapp.service;

import java.util.List;

import myapp.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(int userId);
	
	List<Abonnement> getFollowsByFollower(int userId);
	
	Abonnement follow(int follower, int follows);
	
	void unfollow(int follower, int follows);
}
