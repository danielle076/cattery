package nl.danielle.cattery.controller;

import nl.danielle.cattery.payload.request.CustomerRequest;
import nl.danielle.cattery.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerRequest customerRequest) {
        long newId = customerService.createCustomer(customerRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body("Added new customer");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody CustomerRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest);
        return ResponseEntity.ok().body("Updated customer: " + id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().body("Deleted item: " + id);
    }

    @GetMapping(value = "/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerLastName(@PathVariable("lastname") String lastName) {
        return ResponseEntity.ok().body(customerService.getCustomerByLastName(lastName));
    }
}