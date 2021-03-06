package com.cadcli.test_compasso.repository;

import com.cadcli.test_compasso.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
}

