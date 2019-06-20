package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.enumeration.TypeUser;
import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.repository.UserRepository;
import com.hicouch.back.core.service.UserService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer userId) throws NoResultException {
        return userRepository.findById(userId).orElseThrow(NoResultException::new);
    }

	@Override
	public User setUserStatus(int userId, int status) throws NoResultException {
		User user = userRepository.findById(userId).orElseThrow(NoResultException::new);
		user.setIdstatus(status);
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByAuth0Id(String userId) {
		return userRepository.getUserByIdAuth0(userId);
	}

	@Override
	public User getCurrentUser() throws NoResultException {
		String auth0Id = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> u = getUserByAuth0Id(auth0Id);
		if (u.isPresent()) return u.get();
		
		try {
			String token = getTokenForAuth0();
			JSONObject object = fetchAuth0User(token, auth0Id);
			User newUser = parseUser(object);
			userRepository.save(newUser);
		} catch (UnirestException e) {
			throw new NoResultException();
		}
		
		return getUserByAuth0Id(auth0Id).orElseThrow(NoResultException::new);
	}
	
	private User parseUser(JSONObject object) {
		User u = new User();
		u.setEmail(object.getString("email"));
		u.setIdAuth0(object.getString("user_id"));
		u.setPseudo(object.getString("nickname"));
		u.setPicture(object.getString("picture"));
		u.setTypeUser(TypeUser.USER);
		u.setCreatedAt(LocalDateTime.now());
		u.setUpdatedAt(LocalDateTime.now());
		return u;
	}
	
	private String getTokenForAuth0() throws UnirestException {		
		String client_id = "MbpxkjbtDz0vJX4oBnYSL2QI6mjG0oAc";
		String client_secret = "bH7B7zrdetulJW9Tbv_RghXNHMK10Yq07WrvosF1JCMQRDpfd-6wTZHGvDqsfLkX";
		String audience = "https://hicouch.eu.auth0.com/api/v2/";
		
		HttpResponse<String> response = Unirest.post("https://hicouch.eu.auth0.com/oauth/token")
				  .header("content-type", "application/x-www-form-urlencoded")
				  .body("grant_type=client_credentials&client_id="+ client_id +"&client_secret=" + client_secret + "&audience=" + audience)
				  .asString();
		
		JSONObject jsonObject = new JSONObject(response.getBody());
		String token = jsonObject.getString("access_token");
		
		System.out.println("token : " + token);
		return token;
	}
	
	private JSONObject fetchAuth0User(String token, String auth0Id) throws UnirestException {
		String url = "https://hicouch.eu.auth0.com/api/v2/users/"+auth0Id;
		
		HttpResponse<String> response = Unirest.get(url)
				  .header("content-type", "application/x-www-form-urlencoded")
				  .header("Authorization", "Bearer " + token)
				  .asString();

		return new JSONObject(response.getBody());
	}

	@Override
	public boolean isModeratorOrAdmin(User user) {
		return TypeUser.MODERATOR == user.getTypeUser() || TypeUser.ADMIN == user.getTypeUser();
	}

	@Override
	public User updateUser(User user) throws NoResultException {
		// TODO Auto-generated method stub
		User u = userRepository.findById(user.getId()).orElseThrow(NoResultException::new);
		u.setEmail(user.getEmail());
		u.setPicture(user.getPicture());
		u.setPseudo(user.getPseudo());
		u.setUpdatedAt(LocalDateTime.now());
		return userRepository.save(u);
	}
}
