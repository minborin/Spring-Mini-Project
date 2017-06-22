package com.hrd.borin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/user/user-cu")
	public String userCU(){
		return "/admin/user-cu";
	}
	
	@RequestMapping("/user/user-list")
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
	@RequestMapping("/home")
	public String dashboard(){
		return "/admin/dashboard";
	}
	@RequestMapping("/signin")
	public String signIN(){
		return "/admin/signin";
	}
}
