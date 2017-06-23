package com.hrd.borin.repositories;



import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hrd.borin.model.Users;


@Repository
public interface UserRepository {
//	
//	@Select("SELECT"
//			+ " id ,"
//			+ "name ,"
//			+ "gender,"
//			+ "age,"
//			+ "email,"
//			+ "phone "
//			+ " FROM users ")
	@Select("SELECT id,name,gender ,age,email,phone,user_hash FROM users")
	public List<Users> findAll();
}
