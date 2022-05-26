package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.PropertyDTO;
import com.example.rentalhousemanagementsystem.dto.RentedPropertyDTO;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.entity.RentedProperty;
import com.example.rentalhousemanagementsystem.entity.User;
import com.example.rentalhousemanagementsystem.repository.PropertyRepository;
import com.example.rentalhousemanagementsystem.repository.RentedPropertyRepository;
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
public class RentedPropertyService {

    @Autowired
    private RentedPropertyRepository rentedPropertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveRentedProperty(RentedPropertyDTO rentedPropertyDTO){
        if (rentedPropertyRepository.existsByRecordId(rentedPropertyDTO.getRecordId())){
            return VarList.RSP_DUPLICATED;
        }else {
            rentedPropertyRepository.save(modelMapper.map(rentedPropertyDTO, RentedProperty.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public List<RentedPropertyDTO> getAllProperty() {
        List<RentedProperty> rentedProperties=rentedPropertyRepository.findAll();
        return modelMapper.map(rentedProperties, new TypeToken<ArrayList<RentedPropertyDTO>>() {
        }.getType());
    }
}
