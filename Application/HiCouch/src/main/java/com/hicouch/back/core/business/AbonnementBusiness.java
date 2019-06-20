package com.hicouch.back.core.business;

import com.hicouch.back.core.model.User;

import java.util.List;

public interface AbonnementBusiness {

	List<User> getFollowersByFollows(int userId);

	List<User> getFollowsByFollower(int userId);
}
