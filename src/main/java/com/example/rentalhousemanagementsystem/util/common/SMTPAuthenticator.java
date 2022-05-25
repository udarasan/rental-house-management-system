package com.example.rentalhousemanagementsystem.util.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.mail.PasswordAuthentication;


@Component
public class SMTPAuthenticator extends javax.mail.Authenticator{

    private final String senderEmailId="weranjanadesilva@gmail.com";
    // TODO: 5/25/2022  please make sure turn on google account less secure app access
    private final String senderPassword="****";//put your gmail password here

    public PasswordAuthentication getPasswordAuthentication() {
        System.out.println(senderEmailId);
        return new PasswordAuthentication(senderEmailId,
                senderPassword);
    }

}
