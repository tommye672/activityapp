package com.yhsipi17.activityApp.repository.activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yhsipi17.activityApp.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

	public List<Activity> findAllByOrderByRequestDateAsc();
}
