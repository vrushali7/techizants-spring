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

import com.iiht.model.TrainingDtls;
import com.iiht.model.trainingnotifications;
import com.iiht.service.TrainingService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) 
public class TrainingsController {

	@Autowired
	TrainingService trainingService;
	
	@GetMapping("/training")
	public List<TrainingDtls> getTrainings(){
		return trainingService.getTrainings();
	}
	
	@PostMapping("/training")
	public void addTrainings(@RequestBody TrainingDtls trainingDtls) {
		trainingService.saveTrainings(trainingDtls);
	}
	
	//update delete search
	 @PutMapping("/training")
	 public HttpStatus updateTraining(@RequestBody TrainingDtls trainingDtls) {
		 return trainingService.updateTraining(trainingDtls)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
	 }
	 
	 @DeleteMapping("/training/{id}")
	 public HttpStatus deleteTraining(@PathVariable Long id) {
		 trainingService.deleteTraining(id);
		 return HttpStatus.NO_CONTENT;
	 }
	 
	 @GetMapping("/trainingByTech/{skillName}")
	 public Optional<TrainingDtls> getByTechName(@PathVariable String skillName){
		 return trainingService.getBySkillName(skillName);
	 }
	 
	 @GetMapping("/trainingByMentor/{mentorName}")
	 public Optional<TrainingDtls> getByMentorName(@PathVariable String mentorName){
		 return trainingService.getByMentorName(mentorName);
	 }
	 
	 @GetMapping("/trainingByUser/{userId}")
	 public Optional<TrainingDtls> getByUserId(@PathVariable Long userId){
		 return trainingService.getByUserId(userId);
	 }
	 
	 
	 @GetMapping("/trainingByMentor1/{mentorId}")
	 public List<trainingnotifications> getByMentorId(@PathVariable Long mentorId){
		 return trainingService.getByMentorId(mentorId);
	 }
	 
	 @GetMapping("/trainingByUser1/{userId}")
	 public List<trainingnotifications> getFeedbackByUserId(@PathVariable Long userId){
		 return trainingService.getFeedbackByUserId(userId);
	 }
	 
	 @GetMapping("/trainingByMentor2/{mentorId}")
	 public List<TrainingDtls> getFeedbackByMentorId(@PathVariable Long mentorId){
		 return trainingService.getFeedbackByMentorId(mentorId);
	 }
	 
	 @PostMapping("/addRequest")
	 public void AddRequest(@RequestBody trainingnotifications notify) {
		 trainingService.addRequest(notify);
	 }
}
