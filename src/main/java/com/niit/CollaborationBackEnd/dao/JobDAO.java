package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Job;

public interface JobDAO {

	public List<Job> list();
	public Job get(String id);
	public boolean update(Job job);
	public boolean save(Job job);
	public boolean delete(String id);
}
