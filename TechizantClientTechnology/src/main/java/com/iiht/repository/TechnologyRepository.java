package com.iiht.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iiht.model.Technology;

public interface TechnologyRepository extends CrudRepository<Technology, Long>{

	Optional<Technology> findByName(String name);

}
