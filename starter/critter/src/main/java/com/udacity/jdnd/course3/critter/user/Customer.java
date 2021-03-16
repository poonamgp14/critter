package com.udacity.jdnd.course3.critter.user;

//import com.udacity.jdnd.course3.critter.pet.Pet;
import org.hibernate.annotations.Nationalized;

import javax.persistence.OneToMany;
import java.util.List;

public class Customer extends User{
    @Nationalized
    private String notes;

//    @OneToMany(mappedBy = "customer")
//    private List<Pet> pets;
}
