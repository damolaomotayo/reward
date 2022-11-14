package com.retailer.reward.service;

import com.retailer.reward.entity.Customer;
import com.retailer.reward.records.reqest.CreateNewCustomerParam;
import com.retailer.reward.repositiry.CustomerJpaRepositoryI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class CustomerServiceImplTest {
    @Mock
    CustomerJpaRepositoryI customerRepositoryI;
    @InjectMocks
    CustomerServiceImpl customerService;

    @BeforeAll
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(strings = {"akindele@gmail.com","john@gmail.com","expert@gmail.com"})
    public void createNewCustomer(String email){
        when(customerRepositoryI.save(any(Customer.class))).thenAnswer(invocation->{
            var customer = invocation.getArgument(0,Customer.class);
            customer.setId(1L);
            return customer;
        });
        var result = customerService.createNewCustomer(new CreateNewCustomerParam(
                "Akindele",email,"Dallas Tx"
        ));
       assertEquals("Email not equals",result.getEmail(),email);
    }
}
