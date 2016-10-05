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
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.Friend;

public class FriendController {
	
	@Autowired
	private Friend friend;
	
	@Autowired
	private FriendDAO friendDAO;

	 @GetMapping("/Friend/")
		public ResponseEntity<List<Friend>> listAllFriend() {
			List<Friend> listFriend = friendDAO.list();
			if (listFriend.isEmpty()) {

				return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Friend>>(listFriend, HttpStatus.OK);
		}

		@GetMapping("/Friend/{id}")
		public ResponseEntity<Friend> getFriend(@PathVariable("id") String id) {
			friend = friendDAO.get(id);
			if (friend == null) {
				return new ResponseEntity<Friend>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<Friend>(friend, HttpStatus.OK);

		}

		@PostMapping("/Friend/")
		public ResponseEntity<Void> createFriend(@RequestBody Friend friend,
				UriComponentsBuilder ucBuilder) {
			if (friendDAO.get(friend.getId()) != null) {

				return new ResponseEntity<Void>(HttpStatus.CONFLICT);

			}

			/*
			 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
			 */
			friendDAO.save(friend);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("Friend/{id}/").buildAndExpand(friend.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

		}

		@PutMapping("/Friend/{id}")
		public ResponseEntity<Friend> updateFriend(@PathVariable("id") String id,
				@RequestBody Friend friend) {
			
			if (friendDAO.get(id) == null) {
				return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
			}
			friend.setId(id);

			friendDAO.update(friend);

			return new ResponseEntity<Friend>(friend, HttpStatus.OK);

		}

		@DeleteMapping("/Friend/{id}")
		public ResponseEntity<Friend> deleteFriend(@PathVariable("id") String id) {

			friend = friendDAO.get(id);
			if (friend == null) {

				return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
			}

			friendDAO.delete(id);
			return new ResponseEntity<Friend>(HttpStatus.NO_CONTENT);
		}

}
