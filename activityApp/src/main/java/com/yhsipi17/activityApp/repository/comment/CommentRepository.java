package com.yhsipi17.activityApp.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yhsipi17.activityApp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
