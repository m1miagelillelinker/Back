package com.hicouch.back.core.business;

import java.util.List;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.model.User;

import java.util.List;

public interface AbonnementBusiness {

	List<User> getFollowersByFollows(int userId);

	List<User> getFollowsByFollower(int userId);

	Abonnement follow(Integer follower, Integer follows) throws NoResultException;
}
