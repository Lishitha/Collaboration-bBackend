package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Chat;

public interface ChatDAO
{
	public List<Chat> list();
	public Chat get(String id);
	public boolean update(Chat chat);
	public boolean save(Chat chat);
	public boolean delete(String id);
}
