package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.model.BlogComment;

@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BlogComment blogComment;

	public BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		try 
		{
			this.sessionFactory=sessionFactory;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public List<BlogComment> list()
	{
		String hql = "from BlogComment" ;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<BlogComment> list = query.list();
		
		return list;
	}
	@Transactional
	public boolean save(BlogComment blogComment) {
	
		
		try 
		{
			sessionFactory.getCurrentSession().save(blogComment);
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	
		return true;
	}


	@Transactional
	public boolean update(BlogComment blogComment) {

		try
		{
			sessionFactory.getCurrentSession().update(blogComment);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	
		return true;
	}

	
	@Transactional
	public BlogComment get(String id)
	{
		String hql = "from BlogComment where id=" + "'" + id + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BlogComment> list = query.list();
		
		if(list !=null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
	}
	
	
	
	@Transactional
	public boolean delete(String id)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	

}
