package com.example.vet.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vet.model.User;
import com.example.vet.service.UserService;

@RestController
@RequestMapping("vet/api/user")
public class UserRest {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user){
		
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		
		return ResponseEntity.ok(userService.getUser(null));
	}
	
	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteUser(@RequestParam Long id){
		
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	@PostMapping(path = "/validator", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validation(@RequestBody User user){
		
		return ResponseEntity.ok(userService.validation(user));
	}
	
}
