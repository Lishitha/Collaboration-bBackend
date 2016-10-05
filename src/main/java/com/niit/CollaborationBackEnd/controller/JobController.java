package com.niit.CollaborationBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.CollaborationBackEnd.dao.JobDAO;
import com.niit.CollaborationBackEnd.model.Job;

@RestController
public class JobController {
	
	@Autowired
    private JobDAO jobDAO;

   @Autowired
   private Job job;
   
   
   
   @GetMapping("/Job/")
	public ResponseEntity<List<Job>> listAllJob() {
		List<Job> listJob = jobDAO.list();
		if (listJob.isEmpty()) {

			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Job>>(listJob, HttpStatus.OK);
	}

	@GetMapping("/Job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
		job = jobDAO.get(id);
		if (job == null) {
			return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Job>(job, HttpStatus.OK);

	}

	@PostMapping("/Job/")
	public ResponseEntity<Void> createJob(@RequestBody Job job,
			UriComponentsBuilder ucBuilder) {
		if (jobDAO.get(job.getId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		jobDAO.save(job);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("Job/{id}/").buildAndExpand(job.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/Job/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable("id") String id,
			@RequestBody Job job) {
		
		if (jobDAO.get(id) == null) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		job.setId(id);

		jobDAO.update(job);

		return new ResponseEntity<Job>(job, HttpStatus.OK);

	}

	@DeleteMapping("/Job/{id}")
	public ResponseEntity<Job> deleteJob(@PathVariable("id") String id) {

		job = jobDAO.get(id);
		if (job == null) {

			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}

		jobDAO.delete(id);
		return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
	}


}
