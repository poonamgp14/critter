package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Long save(Schedule schedule){ return scheduleRepository.save(schedule).getId();}

    public Schedule getScheduleById(Long id){ return scheduleRepository.findScheduleByScheduleId(id);}

    public List<Schedule> getSchedules() { return scheduleRepository.findAll();}

    public List<Schedule> getScheduleByPet(Pet pet) { return scheduleRepository.findScheduleByPets(pet);
    }

    public List<Schedule> getScheduleByEmployee(Employee employee) { return scheduleRepository.findScheduleByEmployees(employee);}

    public List<Schedule> getSchedulesByPet(List<Pet> pets) { return scheduleRepository.findByPetsIn(pets);}

//    public List<Schedule> getScheduleByCustomer(Customer customer) { return scheduleRepository.findScheduleByCustomer(customer);}

}
