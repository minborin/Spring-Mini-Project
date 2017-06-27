package com.hrd.borin.controller;


import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.borin.model.MyData;
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
	public String userCU(ModelMap mm){
		mm.addAttribute("user", new Users());
		mm.addAttribute("addStatus", true);
		return "/admin/user-cu";
	}
	@PostMapping("/usersave")
	public String getFormData(@ModelAttribute("user") Users user ,ModelMap mp){
		
		mp.addAttribute("user", userService.save(user));
		
		return "redirect:/user";
		
	}

	@RequestMapping("/user")

	public String findAll(ModelMap model){
		model.addAttribute("user", userService.findAll());
		return "/admin/user-list";
	}
	@GetMapping("/edit/{user_hash}")
	public String edit(ModelMap model, @PathVariable("user_hash") String user_hash){
		
		Users users=userService.findone(user_hash);
	//	System.out.println("user_hash"+users.getUser_hash());
		model.addAttribute("user", users);
		model.addAttribute("addStatus", false);
		return "/admin/user-cu";
	}
	@RequestMapping("/update")
	public String upate(@ModelAttribute("user") Users user){
		System.out.println(user.getUser_hash());
		if(userService.update(user)){
			System.out.println("update success");
		}
		return "redirect:/user";
	}
	@RequestMapping("/remove")
	public String delete(@RequestParam String user_hash){
		if(userService.delete(user_hash)){
			System.out.println("delete success");
		}
		return "redirect:/user";
	}
	
	
	
	@RequestMapping("/info")
	public String data(ModelMap mm){
		mm.addAttribute("allusers",userService.allUsers());
		mm.addAttribute("male",userService.getMale());
		mm.addAttribute("female",userService.getFemale());
		System.out.println(userService.getFemale());
		return "admin/info";
	}
	
	
	
	@RequestMapping("/user-list")
	public String userList(){
		return "redirect:user";
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
	
	
	
	
}
