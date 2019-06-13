package com.hicouch.back.core.business;

import java.util.List;

import com.hicouch.back.core.model.User;

public interface AbonnementBusiness {

	List<User> getFollowersByFollows(int userId);

	List<User> getFollowsByFollower(int userId);
}
