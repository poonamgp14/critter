package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Long save(Customer customer){
        return customerRepository.save(customer).getId();
    }

    public List<Customer> getCustomers(){ return customerRepository.findAll();}
}
