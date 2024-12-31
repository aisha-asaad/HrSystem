package com.hr.service;

import com.hr.exceptions.ResourceNotFoundException;
import com.hr.model.Phone;
import com.hr.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone updatePhone(Long id, Phone updatedPhone) {
        return phoneRepository.findById(id).map(phone -> {
            phone.setNumber(updatedPhone.getNumber());
            return phoneRepository.save(phone);
        }).orElseThrow(() -> new ResourceNotFoundException("Phone not found"));
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}