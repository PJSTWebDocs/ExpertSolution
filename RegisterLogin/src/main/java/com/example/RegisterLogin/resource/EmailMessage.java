package com.example.RegisterLogin.resource;

public class EmailMessage {

	private String subject;
	private String message;
	public EmailMessage() {
	}
	public EmailMessage( String subject, String message) {
		super();

		this.subject = subject;
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}