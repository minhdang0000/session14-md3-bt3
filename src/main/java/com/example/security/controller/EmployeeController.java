package com.example.security.controller;

import com.example.security.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Nguyễn Công Hưởng", 5000.0),
                new Employee(2L, "Phạm Tuấn Bình", 5000.0),
                new Employee(3L, "Nguyễn Văn A", 5000.0)
        );
        return ResponseEntity.ok(employees);
    }
}
