package com.yhsipi17.activityApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="appuser")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(length=255, nullable=false)
	private String fName;

	@Column(length=255, nullable=false)
	private String lName;

	@Column(length=10, unique=true, nullable=false)
	private String initials;
	
	@OneToMany(mappedBy="fk_author")
	private List<Activity> activitiesAuthor;
	
	@OneToMany(mappedBy="owner")
	private List<Activity> activitiesOwner;
	
	@OneToMany(mappedBy= "author")
	private List<Comment> comments;


	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", initials=" + initials + ", lName=" + lName + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getInitials() {
		return initials;
	}


	public void setInitials(String initials) {
		this.initials = initials;
	}


	public List<Activity> getActivitiesAuthor() {
		return activitiesAuthor;
	}


	public void setActivitiesAuthor(List<Activity> activitiesAuthor) {
		this.activitiesAuthor = activitiesAuthor;
	}


	public List<Activity> getActivitiesOwner() {
		return activitiesOwner;
	}


	public void setActivitiesOwner(List<Activity> activitiesOwner) {
		this.activitiesOwner = activitiesOwner;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}