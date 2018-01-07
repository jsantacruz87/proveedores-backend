package com.scjsolutions.coreProveedores.controllers;

import com.scjsolutions.coreProveedores.entities.Customer;
import com.scjsolutions.coreProveedores.repository.CustomerRepository;
import com.scjsolutions.coreProveedores.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/process")
    public String process() {
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }


    @RequestMapping( value = "/customers", method = RequestMethod.GET)
    public @ResponseBody Iterable<Customer> findAll(Model model) {

        return customerService.listAllCustomer();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer findById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "<html>";

        for (Customer cust : repository.findByLastName(lastName)) {
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}

