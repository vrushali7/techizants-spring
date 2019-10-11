package com.iiht.secure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.secure.model.usersModel;
@Repository
public interface SecurityRepository extends CrudRepository<usersModel, Long> {

	usersModel findByUsername(String username);

	

}
