package com.hr.mapper;

import com.hr.dto.EmailDTO;
import com.hr.model.Email;

public class EmailMapper {
    public static EmailDTO toDTO(Email email) {
        if (email == null) return null;
        EmailDTO dto = new EmailDTO();
        dto.setId(email.getId());
        dto.setEmail(email.getEmail());

        dto.setEmployeeId(email.getEmployee() == null ? null : email.getEmployee().getId());
        return dto;
    }

    public static Email toEntity(EmailDTO dto) {
        if (dto == null) return null;
        Email email = new Email();
        email.setId(dto.getId());
        email.setEmail(dto.getEmail());
        return email;
    }
}