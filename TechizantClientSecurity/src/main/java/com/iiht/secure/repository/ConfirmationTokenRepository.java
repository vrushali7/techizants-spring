package com.iiht.secure.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iiht.secure.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long>{

	ConfirmationToken findByConfirmationToken(String confirmationToken);

	@Modifying
    @Query("update usersModel u set u.password = :password, u.reset_password_date=NOW() where u.id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Long id);
}
