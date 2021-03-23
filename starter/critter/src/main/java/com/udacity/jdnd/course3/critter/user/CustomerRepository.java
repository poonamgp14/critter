package com.udacity.jdnd.course3.critter.user;


import com.udacity.jdnd.course3.critter.pet.Pet;
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
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    @PersistenceContext
//    EntityManager entityManager;

    Customer findCustomerById(Long id);

    Customer findCustomerByPets(Long id);

//    List<Pet> pets = entityManager.createQuery(
//            "select pc " +
//                    "from PostComment pc " +
//                    "where pc.post.id = :postId", PostComment.class)
//            .setParameter( "postId", 1L )
//            .getResultList();
}
