package com.example.RegisterLogin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.RegisterLogin.service.EmailSenderService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	@Autowired
	private final JavaMailSender mailSender;

	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmailToUser(String to) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("freelancebridgesols@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject("Response Regarding the query");
		simpleMailMessage.setText("Thanks for contacting us, We will contact you soon.Stay tuned for the further updates.");
		this.mailSender.send(simpleMailMessage);
	}


	@Override
	public void sendEmail(String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("freelancebridgesols@gmail.com");
		simpleMailMessage.setTo("srijayunique@gmail.com");
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);

		this.mailSender.send(simpleMailMessage);

	}
//	
//	@Override
//	public void sendMailWithAttachment(String to, String subject , String cc, String body,String attachment) throws MessagingException{
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
//		mimeMessageHelper.setTo(to);
//		mimeMessageHelper.setCc(cc);
//		mimeMessageHelper.setSubject(subject);
//		mimeMessageHelper.setText(body);
//		
//		FileSystemResource resource = new FileSystemResource(new File(attachment));
//		mimeMessageHelper.addAttachment(resource.getFilename(), resource);
//		mailSender.send(message);
//		
//	}

//	@Value("${spring.mail.username}")
//	private String fromEmail;

	@Override
	public String sendMail(MultipartFile[] file,String to, String cc, String subject, String body) {
		try {
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("freelancebridgesols@gmail.com");
		for (MultipartFile element: file) {
				mimeMessageHelper.addAttachment(element.getOriginalFilename(),
						new ByteArrayResource(element.getBytes())
						);
			}
		
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setCc(cc);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
			
			this.mailSender.send(mimeMessage);

			return "Mail Sent Successfully with Attachment";
		}
		catch (Exception e)
		{
			System.out.println(e);
//			throw new RuntimeException(e);
		}
		return "";
	}


}
