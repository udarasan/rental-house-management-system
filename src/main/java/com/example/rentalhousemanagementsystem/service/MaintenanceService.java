package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.DefectDTO;
import com.example.rentalhousemanagementsystem.dto.MaintenanceDTO;
import com.example.rentalhousemanagementsystem.dto.PaymentDTO;
import com.example.rentalhousemanagementsystem.dto.PropertyDTO;
import com.example.rentalhousemanagementsystem.entity.Defect;
import com.example.rentalhousemanagementsystem.entity.Maintenance;
import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.repository.DefectRepository;
import com.example.rentalhousemanagementsystem.repository.MaintenanceRepository;
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
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository ;

    @Autowired
    private ModelMapper modelMapper;

    public String saveMaintenance(MaintenanceDTO maintenanceDTO){

        if (maintenanceRepository.existsByAppointmentID(maintenanceDTO.getAppointmentID())){
            return VarList.RSP_DUPLICATED;
        }else {
            maintenanceRepository.save(modelMapper.map(maintenanceDTO, Maintenance.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateMaintenance(MaintenanceDTO maintenanceDTO){
        if (maintenanceRepository.existsByAppointmentID(maintenanceDTO.getAppointmentID())){
            maintenanceRepository.save(modelMapper.map(maintenanceDTO, Maintenance.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<MaintenanceDTO> getAllMaintenance() {
        List<Maintenance> maintenances=maintenanceRepository.findAll();
        return modelMapper.map(maintenances, new TypeToken<ArrayList<MaintenanceDTO>>() {
        }.getType());
    }
    public MaintenanceDTO searchMaintenance(int appointmentID) {
        if (maintenanceRepository.existsByAppointmentID(appointmentID)) {
            Maintenance maintenance=maintenanceRepository.findByAppointmentID(appointmentID);
            return modelMapper.map(maintenance,MaintenanceDTO.class);
        } else {
            return null;
        }
    }
}
