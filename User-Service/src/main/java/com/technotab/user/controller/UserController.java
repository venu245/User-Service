package com.technotab.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technotab.user.entity.User;
import com.technotab.user.model.ResponseTemplateVO;
import com.technotab.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getuserwithDepartment(@PathVariable("id") Long Id) {
		return userService.getuserwithDepartment(Id);
		
		
	}
}
