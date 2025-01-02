package com.hr.dto;


public class PhoneDTO {
    private Long id;
    private String phoneNumber;
    private Long employeeId;

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, String phoneNumber, Long employeeId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}

