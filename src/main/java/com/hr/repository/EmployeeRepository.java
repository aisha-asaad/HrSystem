package com.hr.repository;

import com.hr.model.Department;
import com.hr.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    Page<Employee> findByNameContaining(String name, Pageable pageable);
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
//    // Pagination with filtering by department name as an example
//    Page<Employee> findByDepartmentNamePage(String departmentName, Pageable pageable);
//
//    // Pagination with sorting by name
//    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
//
//    // Pagination with sorting by name
//    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable, Sort sort);
//
//    // Filtering by employee name and pagination
//    Page<Employee> findByNameStartingWith(String namePrefix, Pageable pageable);
}
