package com.iiht.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.model.PaymentModel;
import com.iiht.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payment")
	public List<PaymentModel> getPayments(){
		return paymentService.getPayments();
	}
	
	@PostMapping("/payment")
	public void addPayment(@RequestBody PaymentModel paymentModel) {
		paymentService.addPayment(paymentModel);
	}
	
	@PutMapping("/payment")
	public HttpStatus updatePayment(@RequestBody PaymentModel updatePayment) {
		
		return paymentService.updatePayment(updatePayment)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/payment/{id}")
	public HttpStatus deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@GetMapping("/payment/{id}")
	public Optional<PaymentModel> getPaymentById(@PathVariable Long id){
		return paymentService.getById(id);
	}
	
	@GetMapping("/paymentByMentor/{mentorName}")
	public Optional<PaymentModel> getPaymentByMentorName(@PathVariable String mentorName){
		return paymentService.getByMentorName(mentorName);
	}
	
	@GetMapping("/paymentByMentor/{userName}")
	public Optional<PaymentModel> getPaymentByUserName(@PathVariable String userName){
		return paymentService.getByUserName(userName);
	}
}
