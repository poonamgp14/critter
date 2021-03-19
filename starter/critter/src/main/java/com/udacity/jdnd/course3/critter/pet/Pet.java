package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.Customer;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pet")
public class Pet {
    @Column(name="type_code")
    private @Enumerated(EnumType.STRING) PetType type;

    @Id
	@GeneratedValue
    private long id;

    @Nationalized
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
//    https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
    private Customer customer;
    private LocalDate birthDate;

    @Nationalized
    private String notes;

    public PetType getType() { return type;}
    public void setType(PetType type) { this.type =type;}

    public Long getId(){ return id;}

    public void setId(Long id){ this.id = id; }

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer= customer;}

    public LocalDate getBirthDate(){ return birthDate;}

    public void setBirthDate(LocalDate birthDate){ this.birthDate = birthDate;}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//
//        if (!(o instanceof Pet))
//            return false;
//
//        return id != null && id.equals(((Pet) o).getId());
//    }
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
