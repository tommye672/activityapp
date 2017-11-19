package com.yhsipi17.activityApp.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yhsipi17.activityApp.model.User;
import com.yhsipi17.activityApp.repository.user.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAllByOrderByIdAsc();
	}
	
	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(int id){
		userRepository.delete(id);
	}
}

