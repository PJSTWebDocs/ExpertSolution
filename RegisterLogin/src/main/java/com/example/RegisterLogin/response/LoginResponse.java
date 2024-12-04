package com.example.RegisterLogin.response;

public class LoginResponse {

	String Message;
	Boolean status;
	public LoginResponse(String message, Boolean status) {
		super();
		Message = message;
		this.status = status;
	}
	public LoginResponse() {
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoginResponse [Message=" + Message + ", status=" + status + "]";
	}



}
