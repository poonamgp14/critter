package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Long id = petService.save(convertPetDTOToPet(petDTO));
        petDTO.setId(id);
        return petDTO;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return convertPetToPetDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<Pet> pets = petService.getPets();
        return pets.stream().map(p -> convertPetToPetDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        Customer owner = customerService.getCustomerById(ownerId);
        List<Pet> pets = petService.getPetsByCustomer(owner);
        return pets.stream().map(p -> convertPetToPetDTO(p)).collect(Collectors.toList());
    }

    private PetDTO convertPetToPetDTO(Pet p) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(p, petDTO);
        return petDTO;
    }

    private Pet convertPetDTOToPet(PetDTO petDTO) {
        Pet pet = new Pet();
        //copy everything into pet except ownerid
        BeanUtils.copyProperties(petDTO, pet, "ownerId");

        //this is how we save customer field in PET
        Long customerId = petDTO.getOwnerId();
        Customer customer = customerService.getCustomerById(customerId);
        pet.setCustomer(customer);
        return pet;
    }
}
