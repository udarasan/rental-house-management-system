package com.example.rentalhousemanagementsystem.service;

import com.example.rentalhousemanagementsystem.dto.NoticeDTO;
import com.example.rentalhousemanagementsystem.entity.Notice;
import com.example.rentalhousemanagementsystem.repository.NoticeRepository;
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
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String saveNotice(NoticeDTO noticeDTO){

        if (noticeRepository.existsById(noticeDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            noticeRepository.save(modelMapper.map(noticeDTO, Notice.class));
            return VarList.RSP_SUCCESS;
        }

    }
    public String updateNotice(NoticeDTO noticeDTO){
        if (noticeRepository.existsById(noticeDTO.getId())){
            noticeRepository.save(modelMapper.map(noticeDTO, Notice.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }

    }
    public List<NoticeDTO> getAllNotice() {
        List<Notice> notificationList=noticeRepository.findAll();
        return modelMapper.map(notificationList, new TypeToken<ArrayList<NoticeDTO>>() {
        }.getType());
    }
    public NoticeDTO searchNotice(int id) {
        if (noticeRepository.existsById(id)) {
            Notice notice=noticeRepository.findById(id);
            return modelMapper.map(notice,NoticeDTO.class);
        } else {
            return null;
        }
    }
}
