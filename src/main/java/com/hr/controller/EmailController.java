package com.hr.controller;

import com.hr.model.Email;
import com.hr.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @PostMapping
    public Email createEmail(@RequestBody Email email) {
        return emailService.createEmail(email);
    }

    @PutMapping("/{id}")
    public Email updateEmail(@PathVariable Long id, @RequestBody Email updatedEmail) {
        return emailService.updateEmail(id, updatedEmail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.ok().build();
    }
}