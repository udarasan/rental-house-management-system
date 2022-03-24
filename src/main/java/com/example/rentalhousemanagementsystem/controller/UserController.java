package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.Response;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.service.UserService;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private Response response;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDTO userDTO) {
        try {
            String res = userService.saveUser(userDTO);
            if (res.equals("00")) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(userDTO);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else if(res.equals("01")){
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Username Already Use");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setCode(VarList.RSP_ERROR);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }





    }
}
