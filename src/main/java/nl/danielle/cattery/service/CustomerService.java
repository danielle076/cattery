package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Address;
import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.model.CustomerBuilder;
import nl.danielle.cattery.payload.RegisterCustomerRequest;
import nl.danielle.cattery.repository.AddressRepository;
import nl.danielle.cattery.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final
    CustomerRepository customerRepository;

    final
    AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

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

    public long saveCustomer(RegisterCustomerRequest registerCustomerRequest) {

        Customer customer = new CustomerBuilder(registerCustomerRequest).buildCustomer();
        Address address = new CustomerBuilder(registerCustomerRequest)
                .withHousenumberAddition(registerCustomerRequest)
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
