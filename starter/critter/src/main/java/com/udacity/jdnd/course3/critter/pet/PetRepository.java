package com.udacity.jdnd.course3.critter.pet;


import com.udacity.jdnd.course3.critter.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findPetById(Long id);

    List<Pet> findPetsByCustomer(Customer customer);

    List<Pet> findByIdIn(List<Long> petIds);

    @Query("select p.id from Pet p where p.customer = :customer")
    List<Long> findIdsByCustomer(Customer customer);
}

