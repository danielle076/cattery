package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.DatabaseErrorException;
import nl.danielle.cattery.exception.RecordNotFoundException;
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

//    @Override
//    public Customer getCustomerById(long id) {
//        if (!customerRepository.existsById(id)) {
//            throw new RecordNotFoundException();
//        }
//        return customerRepository.findById(id).orElse(null);
//    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException());
    }

    @Override
    public long createCustomer(CustomerRequest customerRequest) {

        Customer customer = new CustomerBuilder(customerRequest).buildCustomer();
        Address address = new CustomerBuilder(customerRequest).buildAddress();

        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);
        address.setCustomer(customer);

        return customerRepository.save(customer).getId();
    }

    @Override
    public void updateCustomer(long id, CustomerRequest customerrequest) {
        if (customerRepository.existsById(id)) {
            try {
                Customer existingCustomer = customerRepository.findById(id).orElse(null);
                Address existingAddress = addressRepository.findById(id).orElse(null);
                existingCustomer.setFirstName(customerrequest.getFirstName());
                existingCustomer.setLastName(customerrequest.getLastName());
                existingCustomer.setDateOfBirth(customerrequest.getDateOfBirth());
                existingCustomer.setEmail(customerrequest.getEmail());
                existingCustomer.setPhoneNumber(customerrequest.getPhoneNumber());
                existingCustomer.setWhichBreed(customerrequest.getWhichBreed());
                existingCustomer.setOtherPets(customerrequest.getOtherPets());
                existingAddress.setStreetName(customerrequest.getStreetName());
                existingAddress.setHouseNumber(customerrequest.getHouseNumber());
                existingAddress.setPostalCode(customerrequest.getPostalCode());
                existingAddress.setHomeTown(customerrequest.getHomeTown());
                customerRepository.save(existingCustomer);
                addressRepository.save(existingAddress);
            } catch (Exception e) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

//    @Override
//    public void deleteCustomer(long id) {
//        customerRepository.deleteById(id);
//    }

    @Override
    public void deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            addressRepository.deleteById(id);

        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName);
    }
}
