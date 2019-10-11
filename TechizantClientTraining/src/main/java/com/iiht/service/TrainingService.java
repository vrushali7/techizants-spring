package com.iiht.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.model.TrainingDtls;
import com.iiht.model.trainingnotifications;
import com.iiht.repository.RequestRepository;
import com.iiht.repository.TrainingRepository;

@Service
@Transactional
public class TrainingService {

	@Autowired
	TrainingRepository trainingRepository;
	
	@Autowired
	RequestRepository requestRepository;

	// show
	public List<TrainingDtls> getTrainings() {
		return (List<TrainingDtls>) trainingRepository.findAll();
	}

	// add
	public void saveTrainings(TrainingDtls trainingDtls) {
		trainingRepository.save(trainingDtls);
	}

	// update
	public boolean updateTraining(TrainingDtls trainingDtls) {
		return trainingRepository.save(trainingDtls) != null;
	}

	// delete
	public void deleteTraining(Long id) {
		trainingRepository.deleteById(id);
	}

	// search by technology name
	public Optional<TrainingDtls> getBySkillName(String skillName) {
		return trainingRepository.getBySkillName(skillName);
	}

	// search by mentor name
	public Optional<TrainingDtls> getByMentorName(String mentorName) {
		return trainingRepository.getByMentorName(mentorName);
	}

	// search by user name
	public Optional<TrainingDtls> getByUserId(Long userId) {
		return trainingRepository.findByUserId(userId);
	}
	
	public List<trainingnotifications> getByMentorId(Long mentorId) {
		return requestRepository.findByMentorId(mentorId);
	}
	
	public List<TrainingDtls> getFeedbackByMentorId(Long mentorId) {
		return trainingRepository.findByMentorId(mentorId);
	}
	
	public List<trainingnotifications> getFeedbackByUserId(Long UserId) {
		return requestRepository.findByUserId(UserId);
	}
//	public boolean RateTrainer(TrainingDtls trainingDtls) {
////		return trainingRepository.updateAvgRating(trainingDtls);
//	}
	
	public void addRequest(trainingnotifications notify) {
		requestRepository.save(notify);
	}
}
