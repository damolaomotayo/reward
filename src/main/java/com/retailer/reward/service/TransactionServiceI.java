package com.retailer.reward.service;

import com.retailer.reward.entity.Transaction;
import com.retailer.reward.records.reqest.CreateNewTransactionParam;

public interface TransactionServiceI {
    Transaction createNewTransaction(CreateNewTransactionParam param);


}
