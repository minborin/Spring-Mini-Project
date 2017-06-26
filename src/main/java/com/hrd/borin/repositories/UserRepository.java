package com.hrd.borin.repositories;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Select("SELECT id,name,gender ,age,email,phone,user_hash FROM users WHERE status='1'")
	public List<Users> findAll();
	
	@Insert("INSERT INTO users VALUES(#{user.id}, #{user.name}, #{user.ge nder} ,#{user.age}, #{user.email}, #{user.phone}, #{user.user_hash})")
	//@Insert("INSERT INTO users VALUES(15, 'name', 'F' ,56, 'ff', 999, 'dfskljdflshghgs')")
	public boolean save(@Param("user")Users user);
	
	@Select("SELECT "
			+ "id,name,gender ,age,email,phone,"
			+ "user_hash FROM users WHERE user_hash=#{user_hash}")
	public Users findOne(@Param("user_hash") String user_hash);
	
	@Update("UPDATE users SET id=#{user.id}, name=#{user.name}, gender=#{user.gender}, age=#{user.age},"
			+ "email=#{user.email}, phone=#{user.phone} WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") Users user);
	
	@Delete("UPDATE users SET status='0' WHERE user_hash =#{user_hash}")
	public boolean delete( String user_hash);
}
