package com.example.TestEntity.service;

import com.example.TestEntity.entity.UserEntity;
import com.example.TestEntity.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    //sendSimpleEmail

    @Autowired
    UserRepositery userRepositery;

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleEmail(String email){
        UserEntity userEntity =this.userRepositery.findByUsername(email).
                orElseThrow(()->new UsernameNotFoundException("This mail is not registered to our system"));

        String body="Your security code is = "+userEntity.getPassword()+ System.lineSeparator()+System.lineSeparator()+"Attention - Keep your security code confidential. This cannot change for any reason. If you face any issue regarding to security code please contact us."+ System.lineSeparator()+System.lineSeparator()+System.lineSeparator()+"Thank you,"+System.lineSeparator()+"MASTERY.LK Administration.";

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("masteryedusl@gmail.com");
        message.setTo(userEntity.getUsername());
        message.setSubject("Mastery Account Password");
        message.setText(body);
        javaMailSender.send(message);
        return "Check your email";
    }
}
