package com.niit.CollaborationBackEnd.TestCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.EventDAO;
import com.niit.CollaborationBackEnd.model.Event;

public class EventTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		Event event = (Event) context.getBean("event");
		
		event.setId("EV02");
		event.setName("EVENT 2");
		event.setDescription("MARRIEGE EVENT 2");
		event.setPlace("CALICUT");
		event.setPostedDate(new Date(System.currentTimeMillis()));
		
		eventDAO.save(event);

	}

}
