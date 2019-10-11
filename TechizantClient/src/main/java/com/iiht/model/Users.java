package com.iiht.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
@Entity
@Table(name = "user")
public class Users {

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private Long id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private Long contact_number;
	private String reg_code;
	private String role;
	private String linkedin_url;
	private float years_of_experience;
	private boolean active=true;
	private boolean confirmed_signup;
	private String reset_password_date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Long getContact_number() {
		return contact_number;
	}
	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}
	public String getReg_code() {
		return reg_code;
	}
	public void setReg_code(String reg_code) {
		this.reg_code = reg_code;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLinkedin_url() {
		return linkedin_url;
	}
	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	public float getYears_of_experience() {
		return years_of_experience;
	}
	public void setYears_of_experience(float years_of_experience) {
		this.years_of_experience = years_of_experience;
	}
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isConfirmed_signup() {
		return confirmed_signup;
	}
	public void setConfirmed_signup(boolean confirmed_signup) {
		this.confirmed_signup = confirmed_signup;
	}
	
	public String getReset_password_date() {
		return reset_password_date;
	}
	public void setReset_password_date(String reset_password_date) {
		this.reset_password_date = reset_password_date;
	}
	public Users(Long id, String username, String password, String first_name, String last_name, Long contact_number,
			String reg_code, String role, String linkedin_url, float years_of_experience, boolean active,
			boolean confirmed_signup, String reset_password_date) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact_number = contact_number;
		this.reg_code = reg_code;
		this.role = role;
		this.linkedin_url = linkedin_url;
		this.years_of_experience = years_of_experience;
		this.active = active;
		this.confirmed_signup = confirmed_signup;
		this.reset_password_date = reset_password_date;
	}
	
	
	
}
