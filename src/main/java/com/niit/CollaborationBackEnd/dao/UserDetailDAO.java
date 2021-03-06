package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.UserDetail;

public interface UserDetailDAO {

	public List<UserDetail> list();
	
	public UserDetail get(String id);
	
	public boolean save(UserDetail userDetail);
	
	public boolean update(UserDetail userdetail);
	
	public boolean delete(String id);
	
}
