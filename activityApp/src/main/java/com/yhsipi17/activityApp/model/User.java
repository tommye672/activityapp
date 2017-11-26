package com.yhsipi17.activityApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="appuser")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer id;

	@NotNull
	@Size(min=2, max=255, message="Min=2 max=255 bokstäver")
	@Column(length=255, nullable=false)
	private String fName;

	@NotNull
	@Size(min=2, max=255, message="Min=2 max=255 bokstäver")
	@Column(length=255, nullable=false)
	private String lName;

	@NotNull
	@Size(min=2 , max=10)
	@Column(length=10, unique=true, nullable=false)
	private String initials;
	
	@OneToMany(mappedBy="fk_author")
	private List<Activity> activitiesAuthor;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL)
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