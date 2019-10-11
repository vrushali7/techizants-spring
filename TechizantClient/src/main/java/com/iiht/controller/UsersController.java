package com.iiht.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.iiht.model.Users;
import com.iiht.service.UsersService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) 
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@GetMapping("/Users")
	public List<Users> getUsers(){
		return usersService.getUsers();
	}
	//add user 
	@PostMapping("/Users")
	public void AddUser(@RequestBody Users users) {
		usersService.saveUser(users);
	}
	
	@GetMapping("/User/{role}")
	public List<Users> getUser(@PathVariable("role") String role){
		System.out.println(role);
		return usersService.getUser(role);
	}
	
	@DeleteMapping("/User/{id}")
	public HttpStatus deleteUser(@PathVariable Long id) {
		usersService.deleteUser(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@GetMapping("/UsersById/{id}")
	public Optional<Users> getUserByID(@PathVariable("id") Long id){
		
		return usersService.getUserById(id);
	}
	
	@PutMapping("/User")
	public HttpStatus updateUser(@RequestBody Users users) {
		return usersService.updateUser(users)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/Activate/{id}")
	public void activateUser(@PathVariable Long id) {
		usersService.activateUser(id);
	}
	
	@PutMapping("/Deactivate/{id}")
	public void deactivateUser(@PathVariable Long id) {
		usersService.deactivateUser(id);
	}
}
