package com.sunbeam.dao;

import com.sunbeam.entities.User;

public interface UserDao {
	String signUp(User user);
	User getUserDetailsById(Long userId);
}
