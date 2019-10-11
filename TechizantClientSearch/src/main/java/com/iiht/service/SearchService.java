package com.iiht.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iiht.model.SearchTrainers;
import com.iiht.repository.SearchRepository;

@Service
@Transactional
public class SearchService {
	@Autowired
	SearchRepository searchRepository;
	
	public List<SearchTrainers> getTrainers(){
		return (List<SearchTrainers>) searchRepository.findAll();
	}
	
	public void addTrainer(SearchTrainers searchTrainers) {
		searchRepository.save(searchTrainers);
	}
	
	//trainer by technology_name
	public List<SearchTrainers> getTrainersByTechnologyname(String technologyname){
		List<SearchTrainers> list1 = new ArrayList<SearchTrainers>();
		List<SearchTrainers> list = (List<SearchTrainers>) searchRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getTechnologyname();
			if(name.contains(technologyname)) {
				list1.add(list.get(i));
			}
		}
		return list1;
		
	}
	
	//trainer by time
	public List<SearchTrainers> getTrainersByTime(String startTime,String endTime){
		return (List<SearchTrainers>) searchRepository.findByStartTimeAndEndTime(startTime,endTime);
	}
	
	//both tech and time
	public List<SearchTrainers> getTrainersByTechOrTime(String technologyname, String startTime, String endTime){
		return (List<SearchTrainers>) searchRepository.getByTechnologynameAndStartTimeAndEndTime(technologyname, startTime, endTime);
	}
	
	//trainer by date
	public List<SearchTrainers> getTrainersByDate(String availFrom, String availTill){

		return (List<SearchTrainers>) searchRepository.findByAvailFromAndAvailTill(availFrom,availTill);
	}
	
	//delete
	
	public void deleteTrainer(Long mentorid) {
		searchRepository.deleteById(mentorid);
	}
	
	//update
	public boolean updateTrainer(SearchTrainers updateTrainer) {
		return searchRepository.save(updateTrainer)!=null;
	}
}
