package com.hr.service;

import com.hr.exceptions.ResourceNotFoundException;
import com.hr.model.Email;
import com.hr.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email createEmail(Email email) {
        return emailRepository.save(email);
    }

    public Email updateEmail(Long id, Email updatedEmail) {
        return emailRepository.findById(id).map(email -> {
            email.setAddress(updatedEmail.getAddress());
            return emailRepository.save(email);
        }).orElseThrow(() -> new ResourceNotFoundException("Email not found"));
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}