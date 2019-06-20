package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AbonnementBusiness;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.factory.UserFactory;
import com.hicouch.back.core.model.Abonnement;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AbonnementService;
import com.hicouch.back.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbonnementBusinessImpl implements AbonnementBusiness {

	private AbonnementService abonnementService;
	private UserService userService;
	private UserFactory userFactory;

	@Autowired
	public AbonnementBusinessImpl(AbonnementService abonnementService, UserService userService,
			UserFactory userFactory) {
		this.abonnementService = abonnementService;
		this.userService = userService;
		this.userFactory = userFactory;
	}

	@Override
	public List<User> getFollowersByFollows(int userId) {
		return abonnementService.getFollowersByFollows(userId).stream()
				.map(Abonnement::getFollower)
				.map(arg0 -> {
					try {
						return userService.getUserById(arg0);
					} catch (NoResultException e) {
						e.printStackTrace();
						return null;
					}
				})
				.filter((u) -> u != null)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> getFollowsByFollower(int userId) {
		return abonnementService.getFollowsByFollower(userId).stream()
			.map(Abonnement::getFollows)
			.map(arg0 -> {
				try {
					return userService.getUserById(arg0);
				} catch (NoResultException e) {
					e.printStackTrace();
					return null;
				}
			})
			.filter((u) -> u != null)
			.collect(Collectors.toList());
	}
}
