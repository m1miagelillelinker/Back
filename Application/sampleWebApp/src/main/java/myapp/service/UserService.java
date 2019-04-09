package myapp.service;

import myapp.model.User;

public interface UserService {
    User getUserById(Integer userId) throws Exception;
}
