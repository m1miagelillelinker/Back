package myapp.service;

import java.util.List;

import myapp.model.Abonnement;

public interface AbonnementService {

	List<Abonnement> getFollowersByFollows(Integer userId);
	
	List<Abonnement> getFollowsByFollower(Integer userId);
}
