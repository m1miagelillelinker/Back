package com.hicouch.back.core.service;

import com.hicouch.back.core.model.User;

public interface UserService {
    User getUserById(Integer userId) throws Exception;
}
