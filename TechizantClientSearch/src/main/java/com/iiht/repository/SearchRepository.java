package com.iiht.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.iiht.model.SearchTrainers;

public interface SearchRepository extends CrudRepository<SearchTrainers, Long>{

	List<SearchTrainers> findBytechnologyname(String technologyname);

	List<SearchTrainers> findByStartTimeAndEndTime(String startTime, String endTime);

	List<SearchTrainers> findByAvailFromAndAvailTill(String availFrom, String availTill);

//	@Query("select s.id,s.mentor_name,s.technologyname,s.toc,s.prerequisites,s.fees from SearchTrainers s where technologyname=?1 and startTime=?2 and endTime=?3")
	List<SearchTrainers> getByTechnologynameAndStartTimeAndEndTime(String technologyname, String startTime, String endTime);
}
