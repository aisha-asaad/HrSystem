package com.hr.service;

import com.hr.dto.EmailDTO;
import com.hr.exceptions.ResourceNotFoundException;
import com.hr.mapper.EmailMapper;
import com.hr.model.Email;
import com.hr.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<EmailDTO> getEmailsByEmployeeId(Long employeeId) {
        return emailRepository.findAll().stream()
                .filter(email -> email.getEmployee() != null && email.getEmployee().getId().equals(employeeId))
                .map(EmailMapper::toDTO)
                .toList();
    }

    public EmailDTO createEmail(EmailDTO dto) {
        Email email = EmailMapper.toEntity(dto);
        return EmailMapper.toDTO(emailRepository.save(email));
    }

    public Email updateEmail(Long id, Email email) {
        email.setId(id);
        return emailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
