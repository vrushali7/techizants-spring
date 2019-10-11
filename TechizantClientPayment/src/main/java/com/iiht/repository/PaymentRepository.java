package com.iiht.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.iiht.model.PaymentModel;

public interface PaymentRepository extends CrudRepository<PaymentModel, Long>{

	Optional<PaymentModel> findByMentorName(String mentorName);

	Optional<PaymentModel> findByUserName(String userName);

}
