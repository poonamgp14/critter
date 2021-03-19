package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.schedule.Schedule;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
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
    private Set<EmployeeSkill> skills= new HashSet<>();

    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "EmployeeDaysAvailableTable",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "dayId")
    private Set<DayOfWeek> daysAvailable = new HashSet<>();


    public void setSkills(Set<EmployeeSkill> skill){
        this.skills = skill;
    }

    public Set<EmployeeSkill> getSkills(){
        return skills;
    }

    public void setDaysAvailable(Set<DayOfWeek> day){
        this.daysAvailable = day;
    }

    public Set<DayOfWeek> getDaysAvailable(){
        return daysAvailable;
    }
}
