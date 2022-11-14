package com.retailer.reward.service;

import com.retailer.reward.entity.Customer;
import com.retailer.reward.entity.Transaction;
import com.retailer.reward.records.reqest.CreateNewCustomerParam;
import com.retailer.reward.records.reqest.GetCustomerRewardParam;

public interface CustomerServiceI {
     Customer createNewCustomer(CreateNewCustomerParam param);
     Customer obtainCustomerTransaction(GetCustomerRewardParam param);
}
