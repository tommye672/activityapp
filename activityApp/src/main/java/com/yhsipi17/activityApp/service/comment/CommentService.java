package com.yhsipi17.activityApp.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yhsipi17.activityApp.model.Comment;
import com.yhsipi17.activityApp.repository.comment.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}	
	
	public Comment findOne(Integer id) {
		return commentRepository.findOne(id);
	}
	
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteComment(int id){
		commentRepository.delete(id);
	}

}
