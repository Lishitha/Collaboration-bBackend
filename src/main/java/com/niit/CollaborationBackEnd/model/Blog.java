package com.niit.CollaborationBackEnd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Blog {

	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private String userId;
	
	private char status;
	
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}	
	
	
}
