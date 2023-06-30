package com.example.vet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.vet.model.User;
import com.example.vet.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		User userFound = userRepository.findByUsername(user.getUsername());
		if (ObjectUtils.isEmpty(userFound)) {
			User userSave = userRepository.save(user);

			return userSave;
		}
		return null;
	}

	public User updateUser(User user) {
		Optional<User> userFound = userRepository.findById(user.getId());
		if (userFound.isPresent()) {
			User userSave = userRepository.save(user);

			return userSave;
		}
		return null;
	}

	public List<User> getUser(Long id) {
		List<User> users = new ArrayList<>();
		if (ObjectUtils.isEmpty(id)) {
			return userRepository.findAll();
		} else {
			users.add(userRepository.findById(id).get());
			return users;
		}
	}

	public boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	// Bug en la validacion por reparar
	public boolean validation(User user) {
		Optional<User> usernameFound = userRepository.findByusername(user.getUsername());
		Optional<User> passwordFound = userRepository.findByPassword(user.getPassword());

		if (usernameFound.isPresent() && passwordFound.isPresent()) {

			return true;

		} else {
			return false;
		}
	}

}
