package com.udacity.jdnd.course3.critter.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.Set;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeById(Long employeeId);

    @Modifying
    @Query("update Employee e set e.daysAvailable= :daysAvailable where e.id= :employeeId")
    void updateEmployeeSetAvailability(@Param("daysAvailable") Set<DayOfWeek> daysAvailable, @Param("employeeId") Long employeeId);

}
