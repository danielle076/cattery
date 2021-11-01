package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    // oud
    @GetMapping(value = "")
    public ResponseEntity<Object> getMessage() {
        return ResponseEntity.ok().body("SECURED REST endpoint: /customers");
    }

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getClients() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer with ID " + id + " deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerLastName(@PathVariable("lastname") String lastName) {
        Customer customer = customerService.getCustomerByLastName(lastName);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
