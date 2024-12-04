package com.example.RegisterLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.RegisterLogin.resource.EmailMessage;
import com.example.RegisterLogin.resource.emailMessageToUser;
import com.example.RegisterLogin.service.EmailSenderService;


@RestController
@CrossOrigin
@RequestMapping("/mail")
public class EmailController {
	@Autowired
    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService)
    {
    	this.emailSenderService=emailSenderService;
    }

    @PostMapping("/send-emailToUser")
    public ResponseEntity<?> sendEmailToUser(@RequestBody emailMessageToUser emailMessageToUser)
    {
    	this.emailSenderService.sendEmailToUser(emailMessageToUser.getTo());
    	return ResponseEntity.ok("Response Send to User Successfully");
    }


    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailMessage emailMessage)
    {
    	this.emailSenderService.sendEmail(emailMessage.getSubject(), emailMessage.getMessage());
    	return ResponseEntity.ok("Success");
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(value="file", required=false)MultipartFile[] file,String to, String cc, String subject , String body) {
    	return emailSenderService.sendMail(file,to,cc,subject,body);
    }
    
    // 
//    @PostMapping("/send")
//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail() throws MessagingException{
//    	emailSenderService 
//    	
//    	
//    }


}
