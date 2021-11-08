package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Address;
import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.model.CustomerBuilder;
import nl.danielle.cattery.payload.CustomerRequest;
import nl.danielle.cattery.repository.AddressRepository;
import nl.danielle.cattery.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    final AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        if (!customerRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public long createAddress(CustomerRequest customerRequest) {

        Customer customer = new CustomerBuilder(customerRequest).buildCustomer();
        Address address = new CustomerBuilder(customerRequest).buildAddress();

        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);
        address.setCustomer(customer);

        return customerRepository.save(customer).getId();
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            try {
                Customer existingCustomer = customerRepository.findById(id).orElse(null);
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                existingCustomer.setDateOfBirth(customer.getDateOfBirth());
                existingCustomer.setEmail(customer.getEmail());
                existingCustomer.setPhoneNumber(customer.getPhoneNumber());
                existingCustomer.setWhichBreed(customer.getWhichBreed());
                existingCustomer.setOtherPets(customer.getOtherPets());
                customerRepository.save(existingCustomer);
            } catch (Exception e) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName);
    }
}
