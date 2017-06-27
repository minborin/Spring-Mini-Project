package com.hrd.borin.service;

import java.util.List;
import java.util.UUID;

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

	@Override
	public boolean save(Users user) {
		String users=UUID.randomUUID().toString();
		user.setUser_hash(users);
		return userRepository.save(user);
		
	}

	@Override
	public boolean update(Users user) {
		
		return userRepository.update(user);
	}



	@Override
	public Users findone(String user_hash) {
		
		return userRepository.findOne(user_hash);
	}

	@Override
	public boolean delete(String user_hash) {
		
		return userRepository.delete(user_hash);
	}

	@Override
	public String getMale() {
		// TODO Auto-generated method stub
		return userRepository.getMale();
	}

	@Override
	public String getFemale() {
		// TODO Auto-generated method stub
		return userRepository.getFemale();
	}

	@Override
	public String allUsers() {
		// TODO Auto-generated method stub
		return userRepository.allUser();
	}

	
	
}
