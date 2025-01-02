package com.hr.mapper;

import com.hr.dto.PhoneDTO;
import com.hr.model.Phone;


public class PhoneMapper {
    public static PhoneDTO toDTO(Phone phone) {
        if (phone == null) return null;
        PhoneDTO dto = new PhoneDTO();
        dto.setId(phone.getId());
        dto.setPhoneNumber(phone.getPhoneNumber());

        dto.setEmployeeId(phone.getEmployee() == null ? null : phone.getEmployee().getId());
        return dto;
    }

    public static Phone toEntity(PhoneDTO dto) {
        if (dto == null) return null;
        Phone phone = new Phone();
        phone.setId(dto.getId());
        phone.setPhoneNumber(dto.getPhoneNumber());
        return phone;
    }
}