package org.library.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.customer.models.Customer;
import org.library.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryUnitTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0,customerRepository.findAll().size()  );
    }

    @Test
    public void testAddOneCustomer(){
        Customer customer = new Customer();
        customer.setCustomerID("1234567890");
        customer.setName("Junior");
        customer.setSurname("Sielinou");
        customer.setTel("333333333");
        customer.setEmail("junsylva@ggg.com");
        customerRepository.save(customer);
        assertEquals(1,customerRepository.findAll().size()  );
    }
}
