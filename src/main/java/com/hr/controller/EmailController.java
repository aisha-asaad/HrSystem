package com.hr.controller;

import com.hr.dto.EmailDTO;
import com.hr.model.Email;
import com.hr.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmailDTO>> getEmailsByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(emailService.getEmailsByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmailDTO> createEmail(@RequestBody EmailDTO dto) {
        return ResponseEntity.ok(emailService.createEmail(dto));
    }

    @PutMapping("/{id}")
    public Email updateEmail(@PathVariable Long id, @RequestBody Email email) {
        return emailService.updateEmail(id, email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
