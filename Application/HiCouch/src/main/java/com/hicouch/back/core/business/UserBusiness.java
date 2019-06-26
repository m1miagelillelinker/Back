package com.hicouch.back.core.business;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.User;

public interface UserBusiness {
    User getUserById(int parseInt) throws NoResultException;
}
