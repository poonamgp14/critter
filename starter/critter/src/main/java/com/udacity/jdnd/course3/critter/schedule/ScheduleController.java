package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    PetService petService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Long id = scheduleService.save(convertScheduleDTOToSchedule(scheduleDTO));
        scheduleDTO.setId(id);
        return scheduleDTO;
    }

    private Schedule convertScheduleDTOToSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule, "pets","employees");

        List<Pet> pets = petService.getPetsById(scheduleDTO.getPetIds());
        List<Employee> employees = employeeService.getEmployeesById(scheduleDTO.getEmployeeIds());
        schedule.setPets(pets);
        schedule.setEmployees(employees);
        return schedule;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getSchedules();
        return schedules.stream().map(s -> convertScheduleToScheduleDTO(s)).collect(Collectors.toList());
    }

    private ScheduleDTO convertScheduleToScheduleDTO(Schedule s) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(s, scheduleDTO);
        return scheduleDTO;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        Pet pet = petService.getPetById(petId);
        List<Schedule> schedules = scheduleService.getScheduleByPet(pet);
        return schedules.stream().map(s -> convertScheduleToScheduleDTO(s)).collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Schedule> schedules = scheduleService.getScheduleByEmployee(employee);
        return schedules.stream().map(s -> convertScheduleToScheduleDTO(s)).collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        List<Pet> pets = petService.getPetsByCustomer(customer);
        List<Schedule> schedules = scheduleService.getSchedulesByPet(pets);
        //List<Schedule> schedules = scheduleService.getScheduleByCustomer(customer);
        return schedules.stream().map(s -> convertScheduleToScheduleDTO(s)).collect(Collectors.toList());
    }
}
