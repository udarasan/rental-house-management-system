package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.entity.User;
import com.example.rentalhousemanagementsystem.repository.UserRepository;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }
    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(user.getRoleCode()));
        return authorities;
    }

    public String saveUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return VarList.RSP_NO_DATA_FOUND;
        } else {
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String deleteUser(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public String updateUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            userRepository.updateUser(userDTO.getAddress(),userDTO.getEmail(),
                    userDTO.getIdPhoto(),userDTO.getName(),userDTO.getPassword(),
                    userDTO.getPhoneNo1(),userDTO.getPhoneNo2(),userDTO.getRemarks(),
                    userDTO.getRoleCode(),userDTO.getStatus(),userDTO.getUsername());
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<UserDTO> getAllUsers() {
        List<User> users=userRepository.findAll();
        return modelMapper.map(users, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    public UserDTO searchUser(String username) {
        if (userRepository.existsByUsername(username)) {
            User user=userRepository.findByUsername(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

}
