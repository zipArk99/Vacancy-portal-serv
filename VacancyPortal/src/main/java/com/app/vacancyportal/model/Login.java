package com.app.vacancyportal.model;

import javax.validation.constraints.NotEmpty;

public class Login {

	@NotEmpty
	final private String email;
	@NotEmpty
	final private String password;
		
		public Login(String email, String password) {
		
			this.email = email;
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}
			
		

	
	

}
