package com.hrd.borin.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hrd.borin.model.Users;

public interface UserService {
		
	
	public List<Users> findAll();
	public boolean save(Users user);
	public boolean update(Users user);
	public boolean delete(String user_hash);
	public Users findone(String user_hash);
	public String getMale();
	public String getFemale();
	public String allUsers();
	
}
