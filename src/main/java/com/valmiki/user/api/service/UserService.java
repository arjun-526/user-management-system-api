package com.valmiki.user.api.service;

import java.util.List;

import com.valmiki.user.api.model.User;

public interface UserService {

	User createUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

	boolean deleteUser(Long id);

	User updateUser(Long id, User user);

}
