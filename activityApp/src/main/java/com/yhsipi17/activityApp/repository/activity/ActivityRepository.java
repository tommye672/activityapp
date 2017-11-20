package com.yhsipi17.activityApp.repository.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yhsipi17.activityApp.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

}
