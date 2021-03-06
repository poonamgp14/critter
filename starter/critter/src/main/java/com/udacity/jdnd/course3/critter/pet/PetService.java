package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Long save(Pet pet){
        return petRepository.save(pet).getId();
    }

    public List<Pet> getPets(){ return petRepository.findAll();}

    public Pet getPetById(Long id) { return petRepository.findPetById(id);}

    public List<Pet> getPetsByCustomer(Customer customer){ return petRepository.findPetsByCustomer(customer);}

    public List<Long> getIdsByCustomer(Customer customer){ return petRepository.findIdsByCustomer(customer);}

    public List<Pet> getPetsById(List<Long> petIds) { return petRepository.findByIdIn(petIds);}
}

