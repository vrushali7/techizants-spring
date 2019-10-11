package com.iiht.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.model.PaymentModel;
import com.iiht.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	//get all payments
	public List<PaymentModel> getPayments(){
		return (List<PaymentModel>) paymentRepository.findAll();
	}
	
	//add payment
	public void addPayment(PaymentModel paymentModel) {
		paymentRepository.save(paymentModel);
	}
	
	//update payment
	public boolean updatePayment(PaymentModel paymentModel) {
		return paymentRepository.save(paymentModel)!=null;
	}
	
	//delete payment
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}
	
	//get by id
	public Optional<PaymentModel> getById(Long id) {
		return paymentRepository.findById(id);
	}
	
	//get by mentor
	public Optional<PaymentModel> getByMentorName(String mentorName){
		return paymentRepository.findByMentorName(mentorName);
	}
	
	//get by user
		public Optional<PaymentModel> getByUserName(String userName){
			return paymentRepository.findByUserName(userName);
		}
}
