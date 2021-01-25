package org.library.customer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.library.customer.models.Customer;
import org.library.customer.repos.CustomerRepository;
import org.library.customer.services.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/lib/customers/")
public class CustomerController {

    @Autowired
    TraceService traceService;

    @Autowired
    private CustomerRepository customerRepository;

    //CREATE
    @RequestMapping(method = RequestMethod.PUT)
    public void setCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        System.out.println(customer);
    }

    //READ SINGLE CUSTOMER BY ID
    @RequestMapping(value = "/{customerID}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String customerID){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerID);
        if(optionalCustomer.isPresent()){
            log.info("Successful to get " + customerID);
            System.out.println(optionalCustomer.get());
            return  optionalCustomer.get();
        }
        else{
            log.error(customerID + " does not exist");
            return null;
        }
    }

    //READ ALL CUSTOMER
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomer(){
        log.info("Successful to get all customer");
        System.out.println(customerRepository.findAll());
        return customerRepository.findAll();
    }

    //UPDATE CUSTOMER BY ID
    @RequestMapping(value = "/{customerID}", method = RequestMethod.POST)
    public Customer updateCustomer (@RequestBody Customer customer, @RequestBody String customerID){
        log.info("Successful to update " + customerID);
        System.out.println(customer);
        return customerRepository.save(customer);
    }

    //DELETE SINGLE CUSTOMER BY ID
    @RequestMapping(value = "/{customerID}", method = RequestMethod.DELETE)
    public void deleteCustomer (@PathVariable String customerID){
        log.info("Successful to delete " + customerID);
        customerRepository.deleteById(customerID);
        System.out.println(customerID + " is deleted");
    }

    //DELETE ALL CUSTOMER PRESENT
    @RequestMapping(method = RequestMethod.DELETE)
    public void  deleteAllCustomer (){
        log.info("Successful to delete all");
        customerRepository.deleteAll();
        System.out.println("All Customer are deleted");
    }
}
