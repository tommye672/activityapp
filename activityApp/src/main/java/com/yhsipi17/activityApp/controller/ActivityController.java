package com.yhsipi17.activityApp.controller;

import java.util.Calendar;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yhsipi17.activityApp.model.Activity;
import com.yhsipi17.activityApp.service.activity.ActivityService;
import com.yhsipi17.activityApp.service.status.StatusService;
import com.yhsipi17.activityApp.service.user.UserService;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {

		@Autowired
		private ActivityService activityService;
		@Autowired
		private UserService userService;
		@Autowired
		private StatusService statusService;
		
		// FindAll
		@RequestMapping(value = "/")
		public String getAll(Model model) {
			model.addAttribute("activity", activityService.findAllOrderedByRequestDateAsc());
			return "/activity/index";
		}
		
		// FindOne
		@RequestMapping(value = "/{id}")
		public ModelAndView getActivity(@PathVariable int id) {
			ModelAndView mav = new ModelAndView("/activity/activity");
			mav.addObject("activity", activityService.findOne(id)); 
			return mav;
		}
		
		// Add -> AddForm
	    @GetMapping("/add")
	    public String addForm(Model model) {
	        model.addAttribute("activity", new Activity());
	        model.addAttribute("users", userService.findAll());
	        model.addAttribute("status", statusService.findAll());
	        return "/activity/addactivity"; 
	    }

	    // Edit -> AddForm
	    @GetMapping("/edit/{id}")
	    public String editActivity(@PathVariable int id, Model model) {
	        model.addAttribute("activity", activityService.findOne(id));
	        model.addAttribute("users", userService.findAll());
	        model.addAttribute("status", statusService.findAll());
	        return "/activity/addactivity";
	    }    
	    
	    // Save
		@PostMapping("/add")
		public String saveActivity(@Valid Activity activity, BindingResult bindingResult, Model model ) {
	
	        if (bindingResult.hasErrors()) {
		        model.addAttribute("users", userService.findAll());
		        model.addAttribute("status", statusService.findAll());
	        	return "/activity/addactivity"; 
	        }
	        
	        // Datum ska bara skrivas när aktiviteten skapas. 
	        // TODO Undersök om en timestamp skapas per automatik vid onCreate
			if (activity.getPubDate() == null) {
				Date today = Calendar.getInstance().getTime();
				activity.setPubDate(today);
			}

			activityService.saveActivity(activity);

			return "redirect:/activity/";
		}

	    // Delete
		@RequestMapping(value = "/remove/{id}")
		public String deleteActivity(@PathVariable int id) {
			
			activityService.deleteActivity(id);
			return "redirect:/activity/";
		}
	}
