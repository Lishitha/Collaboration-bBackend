package com.niit.CollaborationBackEnd.TestCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.UserDetailDAO;
import com.niit.CollaborationBackEnd.model.UserDetail;



public class UserDetailTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		UserDetailDAO userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
		UserDetail userDetail = (UserDetail) context.getBean("userDetail");
		
		userDetail.setId("US02");
		userDetail.setName("AMMU");
		userDetail.seteMail("ammu@gmail.com");
		userDetail.setPassWord("AMMU");
		userDetail.setAddress("THRISSUR");
		userDetail.setMobNumber("9946161748");
		
		userDetailDAO.save(userDetail);

		System.out.println("*****Data is successfully inserted into the UserDetail table*****");
	}
}
