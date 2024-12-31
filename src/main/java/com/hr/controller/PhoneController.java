package com.hr.controller;

import com.hr.model.Phone;
import com.hr.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @PostMapping
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneService.createPhone(phone);
    }

    @PutMapping("/{id}")
    public Phone updatePhone(@PathVariable Long id, @RequestBody Phone updatedPhone) {
        return phoneService.updatePhone(id, updatedPhone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.ok().build();
    }
}
