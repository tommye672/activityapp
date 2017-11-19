package com.yhsipi17.activityApp.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yhsipi17.activityApp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public List<User> findAllByOrderByIdAsc();
}
