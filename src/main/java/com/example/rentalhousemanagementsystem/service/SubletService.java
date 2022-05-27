package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.DefectDTO;
import com.example.rentalhousemanagementsystem.dto.PaymentDTO;
import com.example.rentalhousemanagementsystem.dto.SubletDTO;
import com.example.rentalhousemanagementsystem.entity.Defect;
import com.example.rentalhousemanagementsystem.entity.Payment;
import com.example.rentalhousemanagementsystem.entity.Sublet;
import com.example.rentalhousemanagementsystem.repository.DefectRepository;
import com.example.rentalhousemanagementsystem.repository.SubletRepository;
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
public class SubletService {
    @Autowired
    private SubletRepository subletRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveSublet(SubletDTO subletDTO){

        if (subletRepository.existsBySubletRecordID(subletDTO.getSubletRecordID())){
            return VarList.RSP_DUPLICATED;
        }else {
            subletRepository.save(modelMapper.map(subletDTO, Sublet.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateSublet(SubletDTO subletDTO){
        if (subletRepository.existsBySubletRecordID(subletDTO.getSubletRecordID())){
            subletRepository.save(modelMapper.map(subletDTO, Sublet.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<SubletDTO> getAllSublets() {
        List<Sublet> subletList=subletRepository.findAll();
        return modelMapper.map(subletList, new TypeToken<ArrayList<SubletDTO>>() {
        }.getType());
    }
    public SubletDTO searchSublets(int subletRecordID) {
        if (subletRepository.existsBySubletRecordID(subletRecordID)) {
            Sublet sublet=subletRepository.findBySubletRecordID(subletRecordID);
            return modelMapper.map(sublet,SubletDTO.class);
        } else {
            return null;
        }
    }
}
