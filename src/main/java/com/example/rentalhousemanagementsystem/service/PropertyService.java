package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.PropertyDTO;
import com.example.rentalhousemanagementsystem.dto.UserDTO;
import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.entity.User;
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
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String registerProperty(PropertyDTO propertyDTO){
        if (propertyRepository.existsByUnitId(propertyDTO.getUnitId())){
            return VarList.RSP_DUPLICATED;
        }else {
            propertyRepository.save(modelMapper.map(propertyDTO,Property.class));
            return VarList.RSP_SUCCESS;
        }

    }

    public String updateProperty(PropertyDTO propertyDTO){
        if (propertyRepository.existsByUnitId(propertyDTO.getUnitId())){
            propertyRepository.save(modelMapper.map(propertyDTO,Property.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<PropertyDTO> getAllUsers() {
        List<Property> propertyList=propertyRepository.findAll();
        return modelMapper.map(propertyList, new TypeToken<ArrayList<PropertyDTO>>() {
        }.getType());
    }
    public PropertyDTO searchProperty(int unitId) {
        if (propertyRepository.existsByUnitId(unitId)) {
            Property property=propertyRepository.findByUnitId(unitId);
            return modelMapper.map(property,PropertyDTO.class);
        } else {
            return null;
        }
    }
}
