package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.KeyMoneyDTO;
import com.example.rentalhousemanagementsystem.dto.ResponseDTO;
import com.example.rentalhousemanagementsystem.service.KeyMoneyService;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/KeyMoney")
public class KeyMoneyController {

    @Autowired
    private KeyMoneyService keyMoneyService;
    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping(value = "/saveDefect")
    public ResponseEntity saveRentedProperty(@RequestBody KeyMoneyDTO keyMoneyDTO ){
        try {
            String res=keyMoneyService.saveKeyMoneyRecord(keyMoneyDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(keyMoneyDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("keyMoney Transaction ID Already Registered");
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
}
