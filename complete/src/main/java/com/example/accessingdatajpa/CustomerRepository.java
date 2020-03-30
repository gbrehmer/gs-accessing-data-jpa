package com.example.accessingdatajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Page<Customer> findByLastName(Pageable pageable, String lastName);

    @Query("FROM Customer c WHERE c.lastName = ?1")
    Page<Customer> findByLastNameWithQuery(Pageable pageable, String lastName);

    Customer findById(long id);
}
