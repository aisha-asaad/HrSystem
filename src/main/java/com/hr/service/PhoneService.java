package com.hr.service;

import com.hr.dto.PhoneDTO;
import com.hr.mapper.PhoneMapper;
import com.hr.model.Phone;
import com.hr.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

//    public List<PhoneDTO> getPhonesByEmployeeId(Long employeeId) {
//        return phoneRepository.findByEmployeeId(employeeId)
//                .stream()
//                .map(PhoneMapper::toDTO)
//                .toList();
//    }

    public PhoneDTO createPhone(PhoneDTO dto) {
        Phone phone = PhoneMapper.toEntity(dto);
        return PhoneMapper.toDTO(phoneRepository.save(phone));
    }

    public Phone updatePhone(Long id, Phone phone) {
        phone.setId(id);
        return phoneRepository.save(phone);
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}
