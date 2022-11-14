package com.retailer.reward.service;

import com.retailer.reward.entity.Customer;
import com.retailer.reward.records.reqest.CreateNewCustomerParam;
import com.retailer.reward.records.reqest.GetCustomerRewardParam;
import com.retailer.reward.repositiry.CustomerJpaRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerServiceI{
    private final CustomerJpaRepositoryI customerRepositoryI;
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Customer createNewCustomer(CreateNewCustomerParam param) {
        var customer = new Customer();
        customer.setEmail(param.email());
        customer.setName(param.name());
        customer.setShippingAddress(param.shippingAddress());
        return customerRepositoryI.save(customer);
    }

    @Override
    @Transactional
    public Customer obtainCustomerTransaction(GetCustomerRewardParam param) {
        return null;
    }
}
