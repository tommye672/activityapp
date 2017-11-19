package com.yhsipi17.activityApp.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="appuser")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(length=255)
	@NotNull
	private String fName;
	@NotNull
	@Column(length=255)
	private String initials;
	@NotNull
	@Column(length=255)
	private String lName;

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