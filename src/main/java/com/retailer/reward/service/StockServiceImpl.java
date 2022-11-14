package com.retailer.reward.service;

import com.retailer.reward.entity.Stock;
import com.retailer.reward.records.reqest.CreateNewStock;
import com.retailer.reward.repositiry.StockJpaRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockServiceI{
    private final StockJpaRepositoryI stockRepositoryI;
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Stock createNewStock(CreateNewStock param) {
        var stock = new Stock();
        stock.setItem(param.item());
        stock.setUnitPrice(param.unitPrice());
        stock.setTimestamp(LocalDateTime.now());
        return stockRepositoryI.save(stock);
    }
}
