package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.service.UserService;
import com.example.rentalhousemanagementsystem.util.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to udara-san !!";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody UserDTO userDTO) throws Exception{
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

        return token;
    }

}
