package com.niit.CollaborationBackEnd.TestCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.BlogCommentDAO;
import com.niit.CollaborationBackEnd.model.BlogComment;

public class BlogCommentTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		BlogCommentDAO blogCommentDAO= (BlogCommentDAO) context.getBean("blogCommentDAO");
		BlogComment blogComment = (BlogComment) context.getBean("blogComment");
		
		blogComment.setId("BC01");
		
		blogComment.setContent("NICE BLOG");
		
		blogComment.setUserId("US02");
		
		blogComment.setCommentedAt(new Date(System.currentTimeMillis()));
		
		blogCommentDAO.save(blogComment);
		
		System.out.println("*****Data successfully added into BlogComment table***** ");


	}

}
