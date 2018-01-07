package com.scjsolutions.coreProveedores.services;

import com.scjsolutions.coreProveedores.entities.Customer;

public interface CustomerService{
    Iterable<Customer> listAllCustomer();

    Customer getCustomerById(Integer id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
