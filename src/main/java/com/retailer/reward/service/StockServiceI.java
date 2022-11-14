package com.retailer.reward.service;

import com.retailer.reward.entity.Stock;
import com.retailer.reward.records.reqest.CreateNewStock;

public interface StockServiceI {
     Stock createNewStock(CreateNewStock param);
}
