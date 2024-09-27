package com.app.service;

import com.app.model.User;

public interface UserService {

    User findUserByJwt(String jwt) throws Exception;

    User findUserByEmail(String email) throws Exception;
}