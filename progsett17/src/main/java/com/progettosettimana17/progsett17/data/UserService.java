package com.progettosettimana17.progsett17.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progettosettimana17.progsett17.model.User;

@Service
public class UserService implements IUserDAO {

	@Autowired
	private UserRepository repo;

	@Override
	public User findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public void save(User u) {
		repo.save(u);

	}

	@Override
	public boolean isPresent(User u) {

		return !repo.findByUsername(u.getUsername()).isEmpty();
	}

	@Override
	public User findByUsername(String username) {

		return repo.findByUsername(username).orElse(null);
	}

	@Override
	public List<User> findAll() {

		return repo.findAll();
	}

}
