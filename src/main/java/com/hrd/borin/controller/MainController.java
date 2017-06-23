package com.hrd.borin.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.borin.model.Users;
import com.hrd.borin.service.UserService;


@Controller
public class MainController {
	public UserService userService;
	
		@Autowired
	 public MainController(UserService userService) {
		this.userService=userService;
	}
	
	@RequestMapping("/user-cu")
	public String userCU(){
		return "/admin/user-cu";
	}
	
	@RequestMapping("/user-list")
	public String userList(){
		return "/admin/user-list";
	}
	@RequestMapping("/role/role-c")
	public String roleC(){
		return "/admin/role-c";
	}
	@RequestMapping("/role/role-list")
	public String roleList(){
		return "/admin/role-list";
	}
	@RequestMapping({"/home","/"})
	public String dashboard(){
		return "/admin/dashboard";
	}
	@RequestMapping("/signin")
	public String signIN(){
		return "/admin/signin";
	}
	//show data from database by respone body 
	
	@RequestMapping("/user")
	@ResponseBody
	public List<Users> findAll(){
		return userService.findAll();
	}
	
//	@RequestMapping("/form-data")
	
	
	
}
