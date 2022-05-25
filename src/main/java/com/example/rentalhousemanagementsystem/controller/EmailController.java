package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.MailDTO;
import com.example.rentalhousemanagementsystem.dto.ResponseDTO;
import com.example.rentalhousemanagementsystem.util.common.SMTPAuthenticator;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
@RequestMapping("api/v1/email")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:otherprops.properties")
public class EmailController {

    private final String senderEmailId="weranjanadesilva@gmail.com";
    private final String emailSMTPServer="smtp.gmail.com";

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/sendNewEmail")
    public ResponseEntity sendNotification(@RequestBody MailDTO mailDTO) {

        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.class",    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.host", emailSMTPServer);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.trust",emailSMTPServer);

            Authenticator auth = new SMTPAuthenticator();

            Session session = Session.getInstance(props, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmailId));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailDTO.getReceiversEmailAddress()));
            message.setSubject(mailDTO.getMailSubject());
            message.setText(mailDTO.getMailContent());

            Transport.send(message);
            System.out.println("Email send successfully.");

            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
