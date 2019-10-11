package com.iiht.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iiht.model.TrainingDtls;
import com.iiht.model.trainingnotifications;

public interface TrainingRepository extends CrudRepository<TrainingDtls, Long>{

	Optional<TrainingDtls> getBySkillName(String skillName);

	Optional<TrainingDtls> getByMentorName(String mentorName);

	Optional<TrainingDtls> findByUserId(Long userId);

	List<TrainingDtls> findByMentorId(Long mentorId);



//	@Query("update trainingdtls s set s.avgRating= where s.mentorId=?1 and s.skillId=?2;")
//	boolean updateAvgRating();



}
