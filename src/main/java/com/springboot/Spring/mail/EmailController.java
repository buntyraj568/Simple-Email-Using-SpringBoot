package com.springboot.Spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController
{
    @Autowired
    EmailService emailService;
    @RequestMapping("/send")
public String sendEmail()
{
    return emailService.sendEmail();

}
@RequestMapping("/sendEmailWithAttachment")
public String sendEmailWithAttachment() throws MessagingException {
return emailService.emailWithAttachment();
}
}
