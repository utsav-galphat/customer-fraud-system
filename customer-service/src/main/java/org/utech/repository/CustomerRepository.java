package org.utech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utech.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
