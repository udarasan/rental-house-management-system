package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.RentedPropertyDTO;
import com.example.rentalhousemanagementsystem.dto.ResponseDTO;
import com.example.rentalhousemanagementsystem.service.RentedPropertyService;
import com.example.rentalhousemanagementsystem.util.util.FileUploadUtil;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/rentedProperty")
public class RentedPropertyController {

    @Autowired
    private RentedPropertyService rentedPropertyService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/uploadRentedAgreementDoc")
    public ResponseEntity registerPropertyImageUpload(@RequestParam("files") MultipartFile[] files) {
        try{
            String uploadDir="uploadRentedAgreementDoc";
            Arrays.asList(files).stream().forEach(file -> {
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                System.out.println(fileName);
                try {
                    FileUploadUtil.saveFile(uploadDir, fileName, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.OK);
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/saveRentedProperty")
    public ResponseEntity saveRentedProperty(@RequestBody RentedPropertyDTO rentedPropertyDTO){
        try {
            String res=rentedPropertyService.saveRentedProperty(rentedPropertyDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(rentedPropertyDTO);
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
}