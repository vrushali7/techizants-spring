package com.iiht.secure.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "user")
public class usersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String reset_password_date;
	
	public usersModel(Long id, String username, String password, String first_name, String last_name,
			Long contact_number, String reg_code, String role, String linkedin_url, float years_of_experience, String reset_password_date) {
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
		this.reset_password_date=reset_password_date;
	}
	
	public usersModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getReset_password_date() {
		return reset_password_date;
	}

	public void setReset_password_date(String reset_password_date) {
		this.reset_password_date = reset_password_date;
	}

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
	@Override
	public String toString() {
		return "usersModel [id=" + id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", contact_number=" + contact_number + ", reg_code="
				+ reg_code + ", role=" + role + ", linkedin_url=" + linkedin_url + ", years_of_experience="
				+ years_of_experience + "]";
	}
	
}
