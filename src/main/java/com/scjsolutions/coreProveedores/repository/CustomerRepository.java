package com.scjsolutions.coreProveedores.repository;

import com.scjsolutions.coreProveedores.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    List<Customer> findByLastName(String lastName);
}
