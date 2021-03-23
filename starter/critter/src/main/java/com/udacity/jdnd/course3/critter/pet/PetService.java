package com.udacity.jdnd.course3.critter.pet;

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
}

