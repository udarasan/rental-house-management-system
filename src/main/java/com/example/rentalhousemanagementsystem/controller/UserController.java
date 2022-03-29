package com.example.rentalhousemanagementsystem.controller;

import com.example.rentalhousemanagementsystem.dto.Response;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.service.UserService;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.ResponseWrapper;
import java.util.List;


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
            } else if (res.equals("01")) {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Username Already Use");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                response.setCode(VarList.RSP_FAIL);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {
        try {
            String res = userService.deleteUser(username);
            if (res.equals("00")) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("Not available user");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.NOT_FOUND);
            } else {
                response.setCode(VarList.RSP_FAIL);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        try {
            String res = userService.updateUser(userDTO);
            if (res.equals("00")) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(userDTO);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("You don't have account yet. please create new account");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                response.setCode(VarList.RSP_FAIL);
                response.setMessage("Error");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/searchUser/{username}")
    public ResponseEntity searchUser(@PathVariable String username) {
        try {
            UserDTO userDTO = userService.searchUser(username);
            if (userDTO !=null) {
                response.setCode(VarList.RSP_SUCCESS);
                response.setMessage("Success");
                response.setContent(userDTO);
                return new ResponseEntity(response, HttpStatus.ACCEPTED);
            } else {
                response.setCode(VarList.RSP_NO_DATA_FOUND);
                response.setMessage("No User Available For this name");
                response.setContent(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers() {
        try{
            List<UserDTO> userDTOList = userService.getAllUsers();
            response.setCode(VarList.RSP_SUCCESS);
            response.setMessage("Success");
            response.setContent(userDTOList);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            response.setCode(VarList.RSP_ERROR);
            response.setMessage(e.getMessage());
            response.setContent(e);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
