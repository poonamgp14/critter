//package com.udacity.jdnd.course3.critter.pet;
//
//import com.udacity.jdnd.course3.critter.user.Customer;
//import org.hibernate.annotations.Nationalized;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="pet")
//public class Pet {
//    @Column(name="type_code")
//    private @Enumerated(EnumType.STRING) PetType type;
//
//    @Id
//	@GeneratedValue
//    private long id;
//
//    @Nationalized
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id", nullable = false)
//    private Customer owner;
//    private LocalDate birthDate;
//
//    @Nationalized
//    private String notes;
//}
