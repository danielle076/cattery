package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImpl implements CustomerService{

    final
    CustomerRepository customerRepository;

//    final
//    AddressRepository addressRepository;

//    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
//        this.customerRepository = customerRepository;
//        this.addressRepository = addressRepository;
//    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    public List<Customer> getCustomers() {
//        return customerRepository.findAll();
//    }

    @Override
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }

//    @Override
//    public Customer getCustomerById(long id) {
//        if (customerRepository.existsById(id)) {
//            return customerRepository.findById(id).orElse(null);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

    @Override
    public Customer getCustomerById(long id) {
        if (!customerRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

//    @Override
//    public long createCustomer(RegisterCustomerRequest registerCustomerRequest) {
//
//        Customer customer = new CustomerBuilder(registerCustomerRequest).buildCustomer();
//        Address address = new CustomerBuilder(registerCustomerRequest)
//                .withHousenumberAddition(registerCustomerRequest)
//                .buildAddress();
//
//        Address savedAddress = addressRepository.save(address);
//        customer.setAddress(savedAddress);
//        address.setCustomer(customer);
//
//        return customerRepository.save(customer).getId();
//    }

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
                existingCustomer.setKids(customer.getKids());
                existingCustomer.setOtherPets(customer.getOtherPets());
                customerRepository.save(existingCustomer);
            } catch (Exception e) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

//    public void deleteCustomer(long id) {
//        if (customerRepository.existsById(id)) {
//            customerRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
//
//    public Customer getCustomerByLastName(String lastName) {
//        Customer customer = customerRepository.findByLastNameIgnoreCase(lastName);
//        return customer;
//    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName);
    }
}
