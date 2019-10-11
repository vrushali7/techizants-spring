package com.iiht.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.model.Technology;
import com.iiht.repository.TechnologyRepository;

@Service
@Transactional
public class TechnologyService {

	@Autowired
	TechnologyRepository technologyRepository;
	
	public List<Technology> getTechnology(){
		return (List<Technology>) technologyRepository.findAll();
	}
	
	public void addTechnology(Technology technology) {
		technologyRepository.save(technology);
	}
	
	//delete
	public void deleteTechnology(Long techid) {
		technologyRepository.deleteById(techid);
	}
	
	//update
	public boolean updateTechnology(Technology technology) {
		return technologyRepository.save(technology)!=null;
	}
	
	//search by name
	public Optional<Technology> searchTechnology(String name){
		return technologyRepository.findByName(name);
	}
}
