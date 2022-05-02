package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.DefectDTO;
import com.example.rentalhousemanagementsystem.dto.PaymentDTO;
import com.example.rentalhousemanagementsystem.entity.Defect;
import com.example.rentalhousemanagementsystem.entity.Payment;
import com.example.rentalhousemanagementsystem.repository.DefectRepository;
import com.example.rentalhousemanagementsystem.repository.PaymentRepository;
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
public class DefectService {

    @Autowired
    private DefectRepository defectRepository ;

    @Autowired
    private ModelMapper modelMapper;

    public String saveDefect(DefectDTO defectDTO){

        if (defectRepository.existsByDefectId(defectDTO.getDefectId())){
            return VarList.RSP_DUPLICATED;
        }else {
            defectRepository.save(modelMapper.map(defectDTO, Defect.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateDefect(DefectDTO defectDTO){
        if (defectRepository.existsByDefectId(defectDTO.getDefectId())){
            defectRepository.save(modelMapper.map(defectDTO, Defect.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<DefectDTO> getAllDefects() {
        List<Defect> defects=defectRepository.findAll();
        return modelMapper.map(defects, new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }
}
