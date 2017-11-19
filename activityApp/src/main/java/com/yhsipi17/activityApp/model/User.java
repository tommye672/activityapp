package com.yhsipi17.activityApp.model;

import java.io.Serializable;
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
	
	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getInitials() {
		return this.initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", initials=" + initials + ", lName=" + lName + "]";
	}

}