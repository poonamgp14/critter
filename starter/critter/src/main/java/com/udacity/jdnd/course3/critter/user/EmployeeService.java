package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.Set;

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

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%-----------------------------------------------");
        System.out.println(daysAvailable);
        System.out.println(employeeRepository.getOne(employeeId));
//        employeeRepository.updateEmployeeSetAvailability(daysAvailable, employeeId);
        employeeRepository.getOne(employeeId).setDaysAvailable(daysAvailable);
    }
}

