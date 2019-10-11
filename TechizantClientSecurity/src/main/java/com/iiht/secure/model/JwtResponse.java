package com.iiht.secure.model;

import java.io.Serializable;

public class JwtResponse implements Serializable  {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private usersModel user;
	public String getJwttoken() {
		return jwttoken;
	}
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public JwtResponse(String jwttoken, usersModel user) {
		super();
		this.jwttoken = jwttoken;
		this.user = user;
	}
	public usersModel getUser() {
		return user;
	}
	public void setUser(usersModel user) {
		this.user = user;
	}
	
}
