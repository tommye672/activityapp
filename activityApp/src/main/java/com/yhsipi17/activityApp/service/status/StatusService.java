package com.yhsipi17.activityApp.service.status;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yhsipi17.activityApp.model.Status;
import com.yhsipi17.activityApp.repository.status.StatusRepository;

@Service
public class StatusService{
	
	@Autowired
	StatusRepository statusRepository;
	
	public List<Status> findAll() {
		return statusRepository.findAll();
	}	
	
	public Status findOne(Integer id) {
		return statusRepository.findOne(id);
	}
	
	public void saveStatus(Status status) {
		statusRepository.save(status);
	}
	
	public void deleteStatus(int id){
		statusRepository.delete(id);
	}
}

