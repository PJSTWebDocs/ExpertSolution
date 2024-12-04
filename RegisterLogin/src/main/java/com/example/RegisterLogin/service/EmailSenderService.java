package com.example.RegisterLogin.service;

import org.springframework.web.multipart.MultipartFile;


public interface EmailSenderService {

	void sendEmailToUser(String to);

	void sendEmail(String subject, String message);

	String sendMail(MultipartFile[]file,String to, String cc, String subject, String body);
//	String sendMail(String to, String cc, String subject, String body);
//	void sendMailWithAttachment(String to, String subject , String cc, String body,String attachment) throws MessagingException;

}
