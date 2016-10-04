package com.niit.CollaborationBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
		List<UserDetail> listUserDetail = userDetailDAO.list();
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
	
	@PostMapping("/UserDetail/")
	public ResponseEntity<Void> createUserDetail(@RequestBody UserDetail userDetail, UriComponentsBuilder ucBuilder)
	{
		if (userDetailDAO.get(userDetail.getId())!= null )
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userDetailDAO.save(userDetail);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("UserDeatail/{id}/").buildAndExpand(userDetail.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/UserDetail/{id}")
	public ResponseEntity<UserDetail> updateUserDetail(@PathVariable("id") String id, @RequestBody UserDetail userDetail)
	{
		if(userDetail.getId() == null)
		{
			return new ResponseEntity<UserDetail>(HttpStatus.NOT_FOUND);
		}
		userDetail.setId(id);
		userDetailDAO.update(userDetail);
		return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
	}
	
	@DeleteMapping("/UserDetail/{id}")
	public ResponseEntity<UserDetail> deleteUserDetail(@PathVariable("id") String id)
	{
		userDetail= userDetailDAO.get(id);
		if(userDetail==null)
		{
			return new ResponseEntity<UserDetail>(HttpStatus.NOT_FOUND);
		}
		userDetailDAO.delete(id);
		return new ResponseEntity<UserDetail>(HttpStatus.NO_CONTENT);
	}

	
}
