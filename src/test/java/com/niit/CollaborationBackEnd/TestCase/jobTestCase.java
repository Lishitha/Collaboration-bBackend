package com.niit.CollaborationBackEnd.TestCase;

import java.util.Date;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.CollaborationBackEnd.dao.JobDAO;
import com.niit.CollaborationBackEnd.model.Job;

public class jobTestCase {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.CollaborationBackEnd");
		context.refresh();
		
		JobDAO jobDAO= (JobDAO) context.getBean("jobDAO");
		Job job = (Job) context.getBean("job");
		
		job.setId("JB02");
		
		job.setJobtitle("HR");
		
		job.setDescription("HR 1");
		
		job.setRequirement("DEGREE,PG");
		
		job.setCompany("TCS");
		
		job.setDateofposting(new Date(System.currentTimeMillis()));
		
		jobDAO.save(job);
		
		System.out.println("*****Data is successfully inserted into the Job thable*****");



	}

}
