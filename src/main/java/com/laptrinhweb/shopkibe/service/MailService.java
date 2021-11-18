package com.laptrinhweb.shopkibe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    public JavaMailSender mailSender;


    public boolean sendSimpleEmail(String emailReceive, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(emailReceive);
        message.setSubject("ShopKi Xác thực");
        message.setText("Your OTP: "+ otp);

        this.mailSender.send(message);

        return true;
    }
}
