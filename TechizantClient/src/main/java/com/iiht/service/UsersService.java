package com.iiht.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.model.Users;
import com.iiht.repository.UsersRepository;

@Service
@Transactional
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	public List<Users> getUsers(){
//		return (List<Users>) usersRepository.findByRole("admin");
		return (List<Users>) usersRepository.findAll();
	}
	
	public void saveUser(Users users) {
		usersRepository.save(users);
		
	}
	
	public List<Users> getUser(String role){
		return (List<Users>) usersRepository.findByRole(role);
	}
	
	public Optional<Users> getUserById(Long id){
		return  usersRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
	
	public boolean updateUser(Users users) {
		return usersRepository.save(users)!=null;
	}
	
	//activate
	public void activateUser(Long id) {
		usersRepository.activate(id);
	}
	
	//deactivate
	public void deactivateUser(Long id) {
		usersRepository.deactivate(id);
	}
}
