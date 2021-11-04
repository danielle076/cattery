package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.payload.RegisterCustomerRequest;

import java.util.Collection;

public interface CustomerService {
    public abstract Collection<Customer> getCustomers();
    public abstract Customer getCustomerById(long id);
    public long createCustomer(RegisterCustomerRequest registerCustomerRequest);
    public abstract void updateCustomer(long id, Customer customer);
    public abstract void deleteCustomer(long id);
    public abstract Customer getCustomerByLastName(String lastName);
}
