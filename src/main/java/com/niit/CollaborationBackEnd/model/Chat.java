package com.niit.CollaborationBackEnd.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

//import java.util.Date;
@Entity
@Component
public class Chat {

	private String id;
	private String userID;
	private String friendID;
	//private Date dateTime;
	private String message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFriendID() {
		return friendID;
	}
	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}
//	public Date getDateTime() {
//		return dateTime;
//	}
//	public void setDateTime(Date dateTime) {
//		this.dateTime = dateTime;
//	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
