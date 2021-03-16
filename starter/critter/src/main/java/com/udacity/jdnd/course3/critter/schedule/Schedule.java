//package com.udacity.jdnd.course3.critter.schedule;
//
//import com.udacity.jdnd.course3.critter.pet.Pet;
//import com.udacity.jdnd.course3.critter.user.Customer;
//import com.udacity.jdnd.course3.critter.user.Employee;
//import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Schedule {
//    @Id
//	@GeneratedValue
//	private Long scheduleId;
//
//    @OneToOne
//    private Employee employeeId;
//
//    @OneToOne
//    private Pet petId;
//
//    private LocalDateTime deliveryTime;
//    @ElementCollection(targetClass = EmployeeSkill.class)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(
//            name = "ScheduleActivitiesTable",
//            joinColumns = @JoinColumn(name = "scheduleId")
//    )
//    @Column(name = "activity")
//    private final Set<EmployeeSkill> activities= new HashSet<>();
//}
