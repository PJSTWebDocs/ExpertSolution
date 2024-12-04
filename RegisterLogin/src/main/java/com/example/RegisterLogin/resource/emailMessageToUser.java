package com.example.RegisterLogin.resource;

public class emailMessageToUser {
	public String to;

	public emailMessageToUser() {
	}
	public emailMessageToUser(String to, String subject) {
		super();
		this.to = to;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}



}
