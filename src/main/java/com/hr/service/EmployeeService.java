package com.hr.service;

import com.hr.dto.EmployeeDTO;
import com.hr.exceptions.ResourceNotFoundException;
import com.hr.mapper.EmployeeMapper;
import com.hr.model.Employee;
import com.hr.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> getEmployees(String name, Long departmentId, int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
        if (departmentId != null) {
            return employeeRepository.findByDepartmentId(departmentId, pageable);
        }
        return employeeRepository.findByNameContaining(name, pageable);
    }

    public EmployeeDTO createEmployee(Employee dto) {
        Employee employee = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employee.setName(dto.getName());
        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
