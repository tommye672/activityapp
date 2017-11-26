package com.yhsipi17.activityApp.service.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yhsipi17.activityApp.model.Activity;
import com.yhsipi17.activityApp.repository.activity.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	ActivityRepository activityRepository;
	
	public List<Activity> findAll(){
		return activityRepository.findAll();
	}
	
	public List<Activity> findAllOrderedByRequestDateAsc(){
		return activityRepository.findAllByOrderByRequestDateAsc();
	}
	
	public Activity findOne(Integer id){
		return activityRepository.findOne(id);
	}
	
	public void saveActivity(Activity activity){
		activityRepository.save(activity);
	}
	
	public void deleteActivity(int id){
		activityRepository.delete(id);
	}
}
