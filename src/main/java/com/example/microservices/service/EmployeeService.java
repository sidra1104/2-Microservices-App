package com.example.microservices.service;

import com.example.microservices.repository.EmployeeRepository;
import com.example.microservices.entity.Employee;
import com.example.microservices.repository.EmployeeRepository;
import com.example.microservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ModelMapper mapper;

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        logger.info("Employee found: {}", employee);
        return mapper.map(employee, EmployeeResponse.class);
    }

}