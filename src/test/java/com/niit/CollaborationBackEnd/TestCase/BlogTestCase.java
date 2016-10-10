package com.niit.CollaborationBackEnd.TestCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.BlogDAO;
import com.niit.CollaborationBackEnd.model.Blog;

public class BlogTestCase {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		BlogDAO blogDAO= (BlogDAO) context.getBean("blogDAO");
		Blog blog = (Blog) context.getBean("blog");
		
		blog.setId("BL03");
		
		blog.setTitle("BLOG3");
		
		blog.setDescription("This is blog 3");
		
		blog.setUserId("US01");
		
		blog.setStatus('N');
		
		blog.setCreated(new Date(System.currentTimeMillis()));
		
		blogDAO.save(blog);
		
		System.out.println("*****Data successfully added into Blog table***** ");

	}
}


