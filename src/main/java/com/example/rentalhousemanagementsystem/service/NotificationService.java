package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.NotificationDTO;
import com.example.rentalhousemanagementsystem.entity.Notification;
import com.example.rentalhousemanagementsystem.repository.NotificationRepository;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JavaMailSender emailSender;

    public void sendMail(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    public String saveNotification(NotificationDTO notificationDTO){

        if (notificationRepository.existsById(notificationDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            notificationRepository.save(modelMapper.map(notificationDTO, Notification.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateNotification(NotificationDTO notificationDTO){
        if (notificationRepository.existsById(notificationDTO.getId())){
            notificationRepository.save(modelMapper.map(notificationDTO, Notification.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<NotificationDTO> getAllNotification() {
        List<Notification> notificationList=notificationRepository.findAll();
        return modelMapper.map(notificationList, new TypeToken<ArrayList<NotificationDTO>>() {
        }.getType());
    }
    public NotificationDTO searchNotification(int id) {
        if (notificationRepository.existsById(id)) {
            Notification notification=notificationRepository.findById(id);
            return modelMapper.map(notification,NotificationDTO.class);
        } else {
            return null;
        }
    }
}
