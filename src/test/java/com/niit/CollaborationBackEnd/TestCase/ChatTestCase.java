package com.niit.CollaborationBackEnd.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.ChatDAO;
import com.niit.CollaborationBackEnd.model.Chat;

public class ChatTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		ChatDAO chatDAO= (ChatDAO) context.getBean("chatDAO");
		Chat chat = (Chat) context.getBean("chat");
		
		chat.setId("CH02");
		
		chat.setFriendID("FR02");
		
		chat.setUserID("US02");
		
		//chat.setDateTime('2016-10-5');
		
		chat.setMessage("Helllloooooooooo");
		
		chatDAO.save(chat);
		
		System.out.println("*****Data is successfully inserted into the chat thable*****");
	}

}
