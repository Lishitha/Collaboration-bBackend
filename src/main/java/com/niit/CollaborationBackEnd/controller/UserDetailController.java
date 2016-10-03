package com.niit.CollaborationBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.dao.UserDetailDAO;
import com.niit.CollaborationBackEnd.model.UserDetail;

@RestController
public class UserDetailController {
	
	@Autowired
	private UserDetail userDetail;
	
	@Autowired
	private UserDetailDAO userDetailDAO;
	
	@GetMapping("/UserDetail/")
	public ResponseEntity<List<UserDetail>> listAllUserDetail()
	{
		List listUserDetail = userDetailDAO.list();
		if  (listUserDetail.isEmpty())
		{
			return new ResponseEntity<List<UserDetail>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetail>>(listUserDetail,HttpStatus.OK);
	}
	
	@GetMapping("/UserDetail/{id}")
	public ResponseEntity<UserDetail> getUserDetail(@PathVariable("id") String id)
	{
		userDetail = userDetailDAO.get(id);
		if(userDetail == null)
		{
			return new ResponseEntity<UserDetail>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
	}
	
	

}
