package com.udacity.jdnd.course3.critter.user;

//import com.udacity.jdnd.course3.critter.pet.Pet;
//import com.udacity.jdnd.course3.critter.schedule.Schedule;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class Employee extends User{
    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeSkillTable",
            joinColumns = @JoinColumn(name = "userId")
    )
    @Column(name = "skillId")
    private final Set<EmployeeSkill> skillSet= new HashSet<>();

    @ElementCollection(targetClass = EmployeeDaysAvailable.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeDaysAvailableTable",
            joinColumns = @JoinColumn(name = "userId")
    )
    @Column(name = "dayId")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

//    @OneToOne(mappedBy = "employee")
//    Schedule schedule;

    public void setSkillSet(EmployeeSkill skill){
        this.skillSet.add(skill);
    }

    public Set<EmployeeSkill> getSkillSet(){
        return skillSet;
    }

    public void setDaysAvailable(DayOfWeek day){
        this.daysAvailable.add(day);
    }

    public Set<DayOfWeek> getDaysAvailable(){
        return daysAvailable;
    }
}
