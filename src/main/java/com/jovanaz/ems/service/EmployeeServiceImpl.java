package com.jovanaz.ems.service;

import com.jovanaz.ems.dto.EmployeeDto;
import com.jovanaz.ems.entity.Employee;
import com.jovanaz.ems.mapper.EmployeeMapper;
import com.jovanaz.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}