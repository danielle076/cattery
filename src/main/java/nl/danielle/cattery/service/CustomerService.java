package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.DatabaseErrorException;
import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.model.Address;
import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.model.CustomerBuilder;
import nl.danielle.cattery.payload.RegisterUserRequest;
import nl.danielle.cattery.repository.AddressRepository;
import nl.danielle.cattery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public long saveCustomer(RegisterUserRequest registerUserRequest) {

        Customer customer = new CustomerBuilder(registerUserRequest).buildCustomer();
        Address address = new CustomerBuilder(registerUserRequest)
                .withHousenumberAddition(registerUserRequest)
                .buildAddress();

        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);
        address.setCustomer(customer);

        return customerRepository.save(customer).getId();
    }

    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    public void updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            try {
                Customer existingCustomer = customerRepository.findById(id).orElse(null);
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                existingCustomer.setDateOfBirth(customer.getDateOfBirth());
                customerRepository.save(existingCustomer);
            } catch (Exception e) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Customer getCustomerByLastName(String lastName) {
        Customer customer = customerRepository.findByLastNameIgnoreCase(lastName);
        return customer;
    }
}
