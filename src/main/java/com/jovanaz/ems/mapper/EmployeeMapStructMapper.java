package com.jovanaz.ems.mapper;

import com.jovanaz.ems.dto.EmployeeDto;
import com.jovanaz.ems.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapStructMapper {

    Employee mapToEmployee(EmployeeDto employeeDto);
    EmployeeDto mapToEmployeeDto(Employee employee);
}
