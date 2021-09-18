package com.technotab.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.technotab.user.entity.User;
import com.technotab.user.model.Department;
import com.technotab.user.model.ResponseTemplateVO;
import com.technotab.user.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	public ResponseTemplateVO getuserwithDepartment(Long id) {
		// TODO Auto-generated method stub
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Optional<User> user = userRepo.findById(id);
		User user1 = user.get();
		
		String url = "http://localhost:8080/department/" + user1.getDepartmentId();
		Department department = restTemplate.getForObject(url, Department.class);
		vo.setUser(user1);
		vo.setDepartment(department);
		return vo;
	}

}
