package org.steri.Library.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final JavaMailSender mailSender;
    private final String senderEmail;

    public EmailNotificationServiceImpl(JavaMailSender mailSender, @Value("${spring.mail.username}") String senderEmail) {
        this.mailSender = mailSender;
        this.senderEmail = senderEmail;
    }

    @Override
    public void sendNotification(String recipient, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(mailSender.toString());
        mail.setFrom(senderEmail);
        mail.setSubject("Notification");
        mail.setText(message);
        mailSender.send(mail);
    }


}
