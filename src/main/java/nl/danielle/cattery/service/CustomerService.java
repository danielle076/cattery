package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.payload.request.CustomerRequest;

import java.util.Collection;

public interface CustomerService {
    Collection<Customer> getCustomers();
    Customer getCustomerById(long id);
    long createCustomer(CustomerRequest customerRequest);
    void updateCustomer(long id, CustomerRequest customerrequest);
    void deleteCustomer(long id);
    Customer getCustomerByLastName(String lastName);
}
