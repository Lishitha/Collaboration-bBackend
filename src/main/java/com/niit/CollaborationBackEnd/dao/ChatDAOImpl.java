package com.niit.CollaborationBackEnd.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.CollaborationBackEnd.model.Chat;

@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Chat chat;

	public ChatDAOImpl(SessionFactory sessionFactory)
	{
		try
		{
			this.sessionFactory = sessionFactory;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Transactional
	public List<Chat> list() 
	{
		String hql = "from Chat";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Chat> list = query.list();

		return list;
	}

	@Transactional
	public boolean save(Chat chat) {

		try
		{
			sessionFactory.getCurrentSession().save(chat);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Transactional
	public boolean update(Chat chat) {

		try
		{
			sessionFactory.getCurrentSession().update(chat);
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Transactional
	public Chat get(String id)
	{
		String hql = "from Chat where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chat> list = query.list();

		if (list != null && !list.isEmpty())
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
			sessionFactory.getCurrentSession().delete(chat);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
