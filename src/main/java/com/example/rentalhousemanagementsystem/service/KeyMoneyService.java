package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.KeyMoneyDTO;
import com.example.rentalhousemanagementsystem.entity.KeyMoney;
import com.example.rentalhousemanagementsystem.repository.KeyMoneyRepository;
import com.example.rentalhousemanagementsystem.util.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class KeyMoneyService {
    @Autowired
    private KeyMoneyRepository keyMoneyRepository ;

    @Autowired
    private ModelMapper modelMapper;

    public String saveKeyMoneyRecord(KeyMoneyDTO keyMoneyDTO ){

        if (keyMoneyRepository.existsByTransactionID(keyMoneyDTO.getTransactionID())){
            return VarList.RSP_DUPLICATED;
        }else {
            keyMoneyRepository.save(modelMapper.map(keyMoneyDTO, KeyMoney.class));
            return VarList.RSP_SUCCESS;
        }

    }
}
