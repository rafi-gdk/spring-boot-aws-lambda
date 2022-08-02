package com.sonu.aws.repository;

import com.sonu.aws.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByCustomerEmail(String customerEmail);

    Optional<Customer> deleteByCustomerEmail(String customerEmail);

}
