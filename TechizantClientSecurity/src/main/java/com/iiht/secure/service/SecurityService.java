package com.iiht.secure.service;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.iiht.secure.model.usersModel;
import com.iiht.secure.repository.ConfirmationTokenRepository;
import com.iiht.secure.repository.SecurityRepository;
@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private SecurityRepository securityRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	 @Autowired
	    private JavaMailSender sender;
	 
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		usersModel user = securityRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not Found with Username: "+username);
		}
			return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>()) ;
		
		
	}
	public usersModel save(usersModel usersModel) {
//		usersModel newUser = new usersModel();
//		usersModel.setUsername(usersModel.getUsername());
		
		usersModel.setPassword(bcryptEncoder.encode(usersModel.getPassword()));
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(usersModel.getUsername());
            helper.setText("Greetings from my new website (Vrushali Punde) Have a nice day! :)");
            helper.setSubject("Mail From Techizant");
        } catch (MessagingException e) {
            e.printStackTrace();
            
        }
        sender.send(message);
		return securityRepository.save(usersModel);
	}

	public void updatePassword(String password, Long userId) {
        confirmationTokenRepository.updatePassword(password, userId);
    }
	
}
