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
		
		userDetail.setId("US05");
		userDetail.setName("SIDHARTH");
		userDetail.seteMail("sidhu@gmail.com");
		userDetail.setPassWord("SIDHARTH");
		userDetail.setAddress("MUMBAI");
		userDetail.setMobNumber("1122334455");
		
		userDetailDAO.save(userDetail);

		System.out.println("*****Data is successfully inserted into the UserDetail table*****");
	}
}
