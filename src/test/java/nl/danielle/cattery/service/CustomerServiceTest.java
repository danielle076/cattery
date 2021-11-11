package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.model.Customer;
import nl.danielle.cattery.payload.CustomerRequest;
import nl.danielle.cattery.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    CustomerRequest customerRequest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Danielle");
        customer.setLastName("Akker");
        customer.setEmail("danielle@gmail.com");
        customer.setPhoneNumber("0612345678");
        customer.setWhichBreed("Birman");
        customer.setOtherPets("Cat");
        customerRequest.setLastName("Akker");
    }

    @Test
    void testGetCustomerById() {
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(RecordNotFoundException.class, () -> {
            customerService.getCustomerById(1L);

        });
    }
}
