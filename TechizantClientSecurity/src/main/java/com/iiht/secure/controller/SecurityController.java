package com.iiht.secure.controller;

import javax.enterprise.inject.Model;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iiht.secure.config.JwtTokenUtil;
import com.iiht.secure.model.ConfirmationToken;
import com.iiht.secure.model.JwtRequest;
import com.iiht.secure.model.JwtResponse;
import com.iiht.secure.model.PasswordReset;
import com.iiht.secure.model.UserLogin;
import com.iiht.secure.model.usersModel;
import com.iiht.secure.repository.ConfirmationTokenRepository;
import com.iiht.secure.repository.SecurityRepository;
import com.iiht.secure.service.SecurityService;
import com.iiht.secure.service.emailSenderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
public class SecurityController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SecurityRepository securityRepository;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	private emailSenderService emailService;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@ModelAttribute("passwordResetForm")
	public PasswordReset passwordReset() {
		return new PasswordReset();
	}
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
		authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		final UserDetails userDetails = securityService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token,securityRepository.findByUsername(authenticationRequest.getUsername())));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody usersModel userLogin)throws Exception{
		return ResponseEntity.ok(securityService.save(userLogin));
	}
	
	
	
	private void authenticate(String username,String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("USER_DISABLED",e);		
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS",e);
		}
	}
	
	//forgot password
	@PostMapping(value = "/forget-password")
	public String forgotUserPassword(@RequestBody usersModel user) {
		usersModel existingUser = securityRepository.findByUsername(user.getUsername());
		System.out.println(existingUser);
		
		if (existingUser!=null) {
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
			confirmationTokenRepository.save(confirmationToken);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getUsername());
			mailMessage.setSubject("Complete Password Reset");
			mailMessage.setFrom("techizantsources@gmail.com");
			mailMessage.setText("To complete to process, please click here: "
					+"http://localhost:8994/confirm-reset?token="+confirmationToken.getConfirmationToken());
			emailService.sendEmail(mailMessage);
		} else {
			return "error";
		}
		return "EMAIL SENT";
	}
	
	@GetMapping(value = "/confirm-reset")
	
	public ModelAndView validateResetToken(ModelAndView modelAndView,@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		if (token!=null) {
			usersModel user = securityRepository.findByUsername(token.getUser().getUsername());
			securityRepository.save(user);
//			modelAndView.addObject("user",user);
			modelAndView.addObject("token", token.getConfirmationToken());
			modelAndView.setViewName("resetPassword");
		}else {
			modelAndView.addObject("message", "This link is invalid or broken");
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
	
//	@PostMapping(value = "/reset-password")
//	@ResponseBody
//	public ModelAndView resetUserPassword(ModelAndView modelAndView,@RequestBody usersModel user) {
//		if(user.getUsername()!=null) {
//			usersModel tokenUser = securityRepository.findByUsername(user.getUsername());
//			tokenUser.setPassword(encoder.encode(user.getPassword()));
//			securityRepository.save(tokenUser);
//			modelAndView.addObject("message","Password successfully reset. You can now login with new credentials.");
//			modelAndView.setViewName("successResetPassword");
//		}else {
//			modelAndView.addObject("message", "This link is invalid");
//			modelAndView.setViewName("error");
//		}
//		return modelAndView;
//	}
	
	 @PostMapping(value = "/reset-password")
	    @Transactional
	    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Valid PasswordReset form,
	                                      BindingResult result,
	                                      RedirectAttributes redirectAttributes, ModelAndView modelAndView) {

	        if (result.hasErrors()){
	            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".passwordResetForm", result);
	            redirectAttributes.addFlashAttribute("passwordResetForm", form);
	            return "redirect:/reset-password?token=" + form.getToken();
	        }

	        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(form.getToken());
	        usersModel user = token.getUser();
	        String updatedPassword = encoder.encode(form.getPassword());
	        securityService.updatePassword(updatedPassword, user.getId());
	        confirmationTokenRepository.delete(token);
	        modelAndView.setViewName("successResetPassword");
	        
	        return "successResetPassword";
	    }

	}

