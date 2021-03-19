package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Long save(Employee employee){
        return employeeRepository.save(employee).getId();
    }


    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }
}

