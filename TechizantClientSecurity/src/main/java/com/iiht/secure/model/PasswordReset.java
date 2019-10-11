package com.iiht.secure.model;

public class PasswordReset {

	private String password;
	private String confirmPassword;
	private String token;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public PasswordReset(String password, String confirmPassword, String token) {
		super();
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.token = token;
	}
	public PasswordReset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
