package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Long save(Employee employee){
        return employeeRepository.save(employee).getId();
    }


    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId){
        employeeRepository.getOne(employeeId).setDaysAvailable(daysAvailable);
    }

    public List<Employee> getEmployeesForService(DayOfWeekGIT  daysAvailable, Set<EmployeeSkill> skills) { return employeeRepository.findEmployeesByDaysAvailableAndSkillsIn(daysAvailable, skills);}

    public List<Employee> getEmployeesById(List<Long> employeeIds) { return employeeRepository.findByIdIn(employeeIds);}
}

