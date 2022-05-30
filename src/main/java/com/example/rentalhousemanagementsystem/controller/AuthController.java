package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.AuthDTO;
import com.example.rentalhousemanagementsystem.dto.ResponseDTO;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.service.UserService;
import com.example.rentalhousemanagementsystem.util.util.JwtUtil;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to udara-san !!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO) throws Exception{
        System.out.println(userDTO);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDTO.getUsername(),
                            userDTO.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(userDTO.getUsername());

        final String token =
                jwtUtil.generateToken(userDetails);

        if (token!=null  && !token.isEmpty() ){

            UserDTO userDTO1=userService.loadUserDetailsByUsername(userDTO.getUsername());
            AuthDTO authDTO = new AuthDTO();
            authDTO.setUsername(userDTO1.getName());
            authDTO.setToken(token);

            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(authDTO);
            return new ResponseEntity(responseDTO, HttpStatus.OK);
        }
        responseDTO.setCode(VarList.RSP_ERROR);
        responseDTO.setMessage("User Name Not Found");
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

}
