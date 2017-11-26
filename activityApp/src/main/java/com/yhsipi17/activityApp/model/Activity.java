package com.yhsipi17.activityApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="activity")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private String text;

	@ManyToOne
	@JoinColumn(name= "fk_author")
	private User fk_author;
	
	@ManyToOne
	@JoinColumn(name= "fk_owner")
	private User owner;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date pubDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date requestDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finishedDate;
	
	@ManyToOne
	@JoinColumn(name= "fk_activity")
	private Status status;
	
	@OneToMany(mappedBy= "activity",orphanRemoval=true, cascade = CascadeType.ALL)
	private List<Comment> comments;

	@Override
	public String toString() {
		return "Activity [id=" + id + ", text=" + text + ", author=" + fk_author + ", owner=" + owner + ", pubDate="
				+ pubDate + ", requestDate=" + requestDate + ", endDate=" + finishedDate + ", status=" + status
				+ ", comments=" + comments + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return fk_author;
	}

	public void setAuthor(User author) {
		this.fk_author = author;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getEndDate() {
		return finishedDate;
	}

	public void setEndDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {	
		//this.comments = comments;
	    this.comments.clear();
	    if (comments != null) {
	      this.comments.addAll(comments);
	    }
	}
}