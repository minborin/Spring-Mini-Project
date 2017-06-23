package com.hrd.borin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrd.borin.model.Users;

public interface UserService {
		
	
	public List<Users> findAll();
}
