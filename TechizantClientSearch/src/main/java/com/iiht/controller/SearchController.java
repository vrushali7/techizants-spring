package com.iiht.controller;

import java.util.List;
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


import com.iiht.model.SearchTrainers;

import com.iiht.service.SearchService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/trainer")
	public List<SearchTrainers> getTrainers(){
		return searchService.getTrainers();
	}
	
	@PostMapping("/trainer")
	public void addTrainer(@RequestBody SearchTrainers searchTrainers) {
		searchService.addTrainer(searchTrainers);
	}
	
	
	@GetMapping("/trainer/{technologyname}")
	public List<SearchTrainers> getTrainerByTechnologyname(@PathVariable String technologyname){
		return searchService.getTrainersByTechnologyname(technologyname);
	}
	
	@GetMapping("/trainerTime/")
	public List<SearchTrainers> getTrainerByTime(@PathVariable String startTime, @PathVariable String endTime){
		return searchService.getTrainersByTime(startTime, endTime);
	}
	
	@GetMapping("/trainer/{technologyname}/{startTime}/{endTime}")
	public List<SearchTrainers> getTrainerByTechOrTime(@PathVariable String technologyname,@PathVariable String startTime, @PathVariable String endTime){
		return searchService.getTrainersByTechOrTime(technologyname, startTime, endTime);
	}
	
	@GetMapping("/trainerDate/{availFrom}/{availTill}")
	public List<SearchTrainers> getTrainerByDate(@PathVariable String availFrom, @PathVariable String availTill){
		return searchService.getTrainersByDate(availFrom, availTill);
	}
	
	@DeleteMapping("/trainer/{mentor_id}")
	public HttpStatus deleteTrainer(@PathVariable Long mentor_id) {
		searchService.deleteTrainer(mentor_id);
		return HttpStatus.NO_CONTENT;
	}
	
	@PutMapping("/trainer")
	public HttpStatus updateTrainer(@RequestBody SearchTrainers updateTrainer) {
		return searchService.updateTrainer(updateTrainer)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
	}
}
