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
import com.niit.CollaborationBackEnd.dao.ChatDAO;
import com.niit.CollaborationBackEnd.model.Chat;

@RestController
public class ChatController {

	@Autowired
	private ChatDAO chatDAO;

	@Autowired
	private Chat chat;

	@GetMapping("/Chat/")
	public ResponseEntity<List<Chat>> listAllChat() {
		List<Chat> listChat = chatDAO.list();

		if (listChat.isEmpty()) {
			return new ResponseEntity<List<Chat>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Chat>>(listChat, HttpStatus.OK);
	}

	@GetMapping("/Chat/{id}")
	public ResponseEntity<Chat> getChat(@PathVariable("id") String id) {
		chat = chatDAO.get(id);

		if (chat == null) {
			return new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Chat>(chat, HttpStatus.OK);
	}

	@PostMapping("/Chat/")
	public ResponseEntity<Void> createChat(@RequestBody Chat chat, UriComponentsBuilder ucBuilder) {
		if (chatDAO.get(chat.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		chatDAO.save(chat);

		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(ucBuilder.path("Chat/{id}/").buildAndExpand(chat.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/Chat/{id}")
	public ResponseEntity<Chat> updateChat(@PathVariable("id") String id, @RequestBody Chat chat) {

		if (chatDAO.get(id) == null) {
			return new ResponseEntity<Chat>(HttpStatus.NOT_FOUND);
		}

		chat.setId(id);

		chatDAO.update(chat);

		return new ResponseEntity<Chat>(chat, HttpStatus.OK);

	}

	@DeleteMapping("/Chat/{id}")
	public ResponseEntity<Chat> deleteChat(@PathVariable("id") String id) {

		chat = chatDAO.get(id);

		if (chat == null) {

			return new ResponseEntity<Chat>(HttpStatus.NOT_FOUND);
		}

		chatDAO.delete(id);

		return new ResponseEntity<Chat>(HttpStatus.NO_CONTENT);
	}
}
