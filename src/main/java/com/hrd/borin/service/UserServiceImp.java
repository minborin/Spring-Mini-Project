package com.hrd.borin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.borin.model.Users;
import com.hrd.borin.repositories.UserRepository;
@Service
public class UserServiceImp  implements UserService{

	public UserRepository userRepository;
		
	@Autowired
		 public UserServiceImp(UserRepository userRepositry) {
			this.userRepository=userRepositry;
		}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
}
