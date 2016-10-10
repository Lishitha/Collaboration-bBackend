package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.BlogComment;

public interface BlogCommentDAO {

public List<BlogComment> list();
	
	public BlogComment get(String id);
	
	public boolean update(BlogComment blog);
	
	public boolean save(BlogComment blog);
	
	public boolean delete(String id);

}
