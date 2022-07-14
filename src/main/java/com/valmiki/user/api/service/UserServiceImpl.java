package com.valmiki.user.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.valmiki.user.api.entity.UserEntity;
import com.valmiki.user.api.model.User;
import com.valmiki.user.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User createUser(User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		repository.save(userEntity);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<UserEntity> userEntities = repository.findAll();
		List<User> users = userEntities.stream().map(userEntity -> new User(userEntity.getId(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmailId()))
				.collect(Collectors.toList());
		return users;
	}

	@Override
	public User getUserById(Long id) {
		UserEntity userEntity = repository.findById(id).get();
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);
		return user;
	}

	@Override
	public boolean deleteUser(Long id) {
		UserEntity userEntity = repository.findById(id).get();
		repository.delete(userEntity);
		return true;
	}

	@Override
	public User updateUser(Long id, User user) {
		UserEntity userEntity = repository.findById(id).get();
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEmailId(user.getEmailId());
		repository.save(userEntity);
		return user;
	}
}
