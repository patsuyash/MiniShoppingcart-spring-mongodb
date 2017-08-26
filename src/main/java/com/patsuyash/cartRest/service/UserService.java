package com.patsuyash.cartRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patsuyash.cartRest.domain.User;
import com.patsuyash.cartRest.repository.UserRepository;

/**
 * @author Suyash
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User("1", "user1@gmail.com", "user1"));
		users.add(new User("2", "user2@gmail.com", "user2"));
	}

	public void saveInitialBatch() {
		userRepository.save(users);
	}

}
