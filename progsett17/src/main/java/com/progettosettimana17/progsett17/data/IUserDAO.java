package com.progettosettimana17.progsett17.data;

import java.util.List;

import com.progettosettimana17.progsett17.model.User;

public interface IUserDAO {

	public User findById(Long id);

	public void save(User u);

	public boolean isPresent(User u);

	public User findByUsername(String username);

	public List<User> findAll();

}
