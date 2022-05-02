package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.PaymentDTO;
import com.example.rentalhousemanagementsystem.dto.PropertyDTO;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.entity.Payment;
import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.entity.User;
import com.example.rentalhousemanagementsystem.repository.PaymentRepository;
import com.example.rentalhousemanagementsystem.repository.PropertyRepository;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String savePayment(PaymentDTO paymentDTO){

        if (paymentRepository.existsByPaymentId(paymentDTO.getPaymentId())){
            return VarList.RSP_DUPLICATED;
        }else {
            paymentRepository.save(modelMapper.map(paymentDTO, Payment.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String changePaymentStatus(String paymentId,String paymentStatus){
        if (paymentRepository.existsByPaymentId(Long.parseLong(paymentId))){
            paymentRepository.changePaymentStatus(paymentId,paymentStatus);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments=paymentRepository.findAll();
        return modelMapper.map(payments, new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }
}
