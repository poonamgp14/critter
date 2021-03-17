package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.schedule.Schedule;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends User{
    @ElementCollection(targetClass = EmployeeSkill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeSkillTable",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "skillId")
    private final Set<EmployeeSkill> skillSet= new HashSet<>();

    @ElementCollection(targetClass = EmployeeDaysAvailable.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeDaysAvailableTable",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "dayId")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Schedule> schedules= new ArrayList<>();

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
