package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.DefectDTO;
import com.example.rentalhousemanagementsystem.dto.KeyMoneyDTO;
import com.example.rentalhousemanagementsystem.entity.Defect;
import com.example.rentalhousemanagementsystem.entity.KeyMoney;
import com.example.rentalhousemanagementsystem.repository.KeyMoneyRepository;
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
public class KeyMoneyService {
    @Autowired
    private KeyMoneyRepository keyMoneyRepository ;

    @Autowired
    private RentedPropertyRepository rentedPropertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveKeyMoneyRecord(KeyMoneyDTO keyMoneyDTO ){

        if (keyMoneyRepository.existsByTransactionID(keyMoneyDTO.getTransactionID())) {
            return VarList.RSP_DUPLICATED;
        } else {
            int currentKeyMoneyValue = Integer.parseInt(rentedPropertyRepository.getCurrentKeyMoneyValue(keyMoneyDTO.getRentedPropertyID().getRecordId()));
            int deductionValue = Integer.parseInt(keyMoneyDTO.getValue());
            int newKeyMoneyValue;
            if (currentKeyMoneyValue > deductionValue) {
                newKeyMoneyValue = currentKeyMoneyValue - deductionValue;
                rentedPropertyRepository.updateCurrentKeyMoneyValue(String.valueOf(newKeyMoneyValue), keyMoneyDTO.getRentedPropertyID().getRecordId());
            }else {
                return VarList.RSP_FAIL;
            }

            keyMoneyRepository.save(modelMapper.map(keyMoneyDTO, KeyMoney.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateKeyMoneyRecord(KeyMoneyDTO keyMoneyDTO){
        if (keyMoneyRepository.existsByTransactionID(keyMoneyDTO.getTransactionID())){
            keyMoneyRepository.save(modelMapper.map(keyMoneyDTO, KeyMoney.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<KeyMoneyDTO> getAllKeyMoneyRecord() {
        List<KeyMoney> keyMonies=keyMoneyRepository.findAll();
        return modelMapper.map(keyMonies, new TypeToken<ArrayList<KeyMoneyDTO>>() {
        }.getType());
    }
    public KeyMoneyDTO searchKeyMoneyRecord(int transactionId) {
        if (keyMoneyRepository.existsByTransactionID(transactionId)) {
            KeyMoney keyMoney=keyMoneyRepository.findByTransactionID(transactionId);
            return modelMapper.map(keyMoney,KeyMoneyDTO.class);
        } else {
            return null;
        }
    }
}
