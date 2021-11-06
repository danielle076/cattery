package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.payload.RegisterCustomerRequest;

import java.util.Collection;

public interface CustomerService {
    Collection<Customer> getCustomers();
    Customer getCustomerById(long id);
    long createAddress(RegisterCustomerRequest registerCustomerRequest);
    void updateCustomer(long id, Customer customer);
    void deleteCustomer(long id);
    Customer getCustomerByLastName(String lastName);
}
