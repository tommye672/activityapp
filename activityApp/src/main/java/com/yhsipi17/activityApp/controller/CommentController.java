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
import com.yhsipi17.activityApp.model.Comment;
import com.yhsipi17.activityApp.service.comment.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	// FindAll
	@RequestMapping(value = "/")
	public String getAll(Model model) {
		model.addAttribute("comment", commentService.findAll());
		return "/comment/index";
	}
	
	// FindOne
	@RequestMapping(value = "/{id}")
	public ModelAndView getComment(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("/comment/comment");
		mav.addObject("comment", commentService.findOne(id)); 
		return mav;
	}
	
	// Add -> AddForm
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "/comment/addcomment";
    }

    // Edit -> AddForm
    @GetMapping("/edit/{id}")
    public String editComment(@PathVariable int id, Model model) {
        model.addAttribute("comment", commentService.findOne(id));
        return "/comment/addcomment";
    }    
    
    // Save
    @PostMapping("/add")
    public String saveComment(@ModelAttribute Comment comment, BindingResult result, ModelMap model){
    	
    	if (result.hasErrors()) {
    		System.out.println(model.toString());
    		return "error";
    	}
    	
    	commentService.saveComment(comment);
    	
        return "redirect:/comment/";
    }
    
    // Delete
	@RequestMapping(value = "/remove/{id}")
	public String deleteComment(@PathVariable int id) {
		commentService.deleteComment(id);
		
		return "redirect:/comment/";
	}
    
    
}
