package com.iiht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.model.Users;

public interface UsersRepository extends CrudRepository<Users, Long>{

	List<Users> findByRole(String role);

	@Transactional
	@Modifying
	@Query("update Users u set u.active=1 where u.id=:id")
	void activate(@Param("id") Long id);

	
	@Transactional
	@Modifying
	@Query("update Users u set u.active=0 where u.id=:id")
	void deactivate(@Param("id") Long id);
	
	
}
