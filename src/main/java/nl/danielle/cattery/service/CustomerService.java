package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Customer;

import java.util.Collection;

public interface CustomerService {
    public abstract Collection<Customer> getCustomers();
    public abstract Customer getCustomerById(long id);
    public abstract long createCustomer(Customer customer);
    public abstract void updateCustomer(long id, Customer customer);
    public abstract void deleteCustomer(long id);
    public abstract Customer getCustomerByLastName(String lastName);
}
