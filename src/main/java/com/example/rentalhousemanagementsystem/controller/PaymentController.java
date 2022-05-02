package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.PaymentDTO;
import com.example.rentalhousemanagementsystem.dto.PropertyDTO;
import com.example.rentalhousemanagementsystem.dto.ResponseDTO;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.service.PaymentService;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/savePayment")
    public ResponseEntity registerProperty(@RequestBody PaymentDTO paymentDTO){
        try {
            String res=paymentService.savePayment(paymentDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(paymentDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Unit Already Registered");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/changePaymentStatus/{paymentId}/{status}")
    public ResponseEntity updateProperty(@PathVariable String paymentId,@PathVariable String status){
        try {
            String res=paymentService.changePaymentStatus(paymentId,status);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not Registered Property");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPayments")
    public ResponseEntity getAllUsers() {
        try{
            List<PaymentDTO> paymentDTOList = paymentService.getAllPayments();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(paymentDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
