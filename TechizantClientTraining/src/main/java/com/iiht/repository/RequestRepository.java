package com.iiht.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iiht.model.TrainingDtls;
import com.iiht.model.trainingnotifications;

public interface RequestRepository extends CrudRepository<trainingnotifications, Long>{

	

	List<trainingnotifications> findByMentorId(Long mentorId);

	List<trainingnotifications> findByUserId(Long userId);

	

}
