package com.charge.ev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
 
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
 
@Service
public class EmailService {
 
    @Autowired
    private JavaMailSender javaMailSender;
 
    public void sendEmail(String to, String subject, String text) throws MailException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 
        helper.setFrom("noreply@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);  // true means HTML content
        
        javaMailSender.send(message);
    }
    
    public void sendEmailAlert(String to, String subject, String messageBody) {
        try {
            this.sendEmail(to, subject, messageBody);
        } catch (Exception e) {
            e.printStackTrace();  // Log error if email fails
        }
    }
}
