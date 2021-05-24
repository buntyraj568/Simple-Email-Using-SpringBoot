package com.springboot.Spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService
{
    @Autowired
    JavaMailSender javaMailSender;

    public String sendEmail()
    {
        SimpleMailMessage massage=new SimpleMailMessage();
        massage.setFrom("raj97javageek2016@gmail.com");
        massage.setTo("singhharsh2177@gmail.com");
        massage.setSubject("Spring boot");
        massage.setText("Email From Spring Boot App Using Gmail");
        javaMailSender.send(massage);
        return "Email Sent";

    }

    public  String emailWithAttachment() throws MessagingException
    {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(message, true);

            SimpleMailMessage massage=new SimpleMailMessage();
            messageHelper.setFrom("raj97javageek2016@gmail.com");
            messageHelper.setTo("");
            messageHelper.setCc("singhharsh2177@gmail.com");
            messageHelper.setSubject("Thank You");
            messageHelper.setText("Email From Spring Boot App Using Gmail With Attachment");
            File file=new File("D:\\documents.zip");
            messageHelper.addAttachment(file.getName(),file);
            javaMailSender.send(message);
            return "sent with attachment";
        }
        catch (Exception e)
        {
            return "Sent failed";

        }

    }
}
