package com.hr.controller;

import com.hr.dto.PhoneDTO;
import com.hr.model.Phone;
import com.hr.service.PhoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
    private final PhoneService phoneService;


//    @GetMapping
//    public ResponseEntity<List<PhoneDTO>> getPhonesByEmployee(@RequestParam Long employeeId) {
//        return ResponseEntity.ok(phoneService.getPhonesByEmployeeId(employeeId));
//    }

    @PostMapping
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody @Valid PhoneDTO phoneDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneService.createPhone(phoneDTO));
    }

    @PutMapping("/{id}")
    public Phone updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        return phoneService.updatePhone(id, phone);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
}
