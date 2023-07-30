package com.jovanaz.ems.controller;

import com.jovanaz.ems.dto.EmployeeDto;
import com.jovanaz.ems.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employee = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
