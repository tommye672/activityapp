package com.yhsipi17.activityApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yhsipi17.activityApp.model.Status;
import com.yhsipi17.activityApp.service.status.StatusService;

@Controller
@RequestMapping(value = "/status")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	// FindAll
	@RequestMapping(value = "/")
	public String getAll(Model model) {
		model.addAttribute("status", statusService.findAll());
		return "/status/index";
	}
	
	// FindOne
	@RequestMapping(value = "/{id}")
	public ModelAndView getStatus(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("/status/status");
		mav.addObject("status", statusService.findOne(id)); 
		return mav;
	}
	
	// Add -> AddForm
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("status", new Status());
        return "/status/addstatus";
    }

    // Edit -> AddForm
    @GetMapping("/edit/{id}")
    public String editStatus(@PathVariable int id, Model model) {
        model.addAttribute("status", statusService.findOne(id));
        return "/status/addstatus";
    }    
    
    // Save
    @PostMapping("/add")
    public String saveStatus(@ModelAttribute Status status, BindingResult result, ModelMap model){
    	
    	if (result.hasErrors()) {
    		System.out.println(model.toString());
    		return "error";
    	}

    	statusService.saveStatus(status);
    	
        return "redirect:/status/";
    }
    
    // Delete
	@RequestMapping(value = "/remove/{id}")
	public String deleteStatus(@PathVariable int id) {
		statusService.deleteStatus(id);
		
		return "redirect:/status/";
	}

}
