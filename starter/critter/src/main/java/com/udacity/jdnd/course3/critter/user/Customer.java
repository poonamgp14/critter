package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.hibernate.annotations.Nationalized;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User{
    @Nationalized
    private String notes;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Pet> pets= new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setCustomer(this);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setCustomer(null);
    }
    public String getNotes(){return notes;}

    public void setNotes(String notes){ this.notes = notes;}
}
