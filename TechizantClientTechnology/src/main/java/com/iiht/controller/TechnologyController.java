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

import com.iiht.model.Technology;

import com.iiht.service.TechnologyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
public class TechnologyController {

	@Autowired
	TechnologyService technologyService;
	
	@GetMapping("/technology")
	public List<Technology> getTechnology(){
		return technologyService.getTechnology();
	}
	
	@PostMapping("/technology")
	public void addTechnology(@RequestBody Technology technology) {
		technologyService.addTechnology(technology);
	}
	
	@DeleteMapping("/technology/{techid}")
	public HttpStatus deleteTechnology(@PathVariable Long techid) {
		technologyService.deleteTechnology(techid);
		return HttpStatus.NO_CONTENT;
	}
	
	@PutMapping("/technology")
	public HttpStatus updateTechnology(@RequestBody Technology technology) {
		return technologyService.updateTechnology(technology)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/technology/{name}")
	public Optional<Technology> searchTechnology(@PathVariable String name){
		return technologyService.searchTechnology(name);
	}
}
