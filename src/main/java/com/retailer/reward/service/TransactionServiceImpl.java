package com.retailer.reward.service;

import com.retailer.reward.PointEstimatorI;
import com.retailer.reward.entity.Reward;
import com.retailer.reward.entity.Transaction;
import com.retailer.reward.records.reqest.CreateNewTransactionParam;
import com.retailer.reward.records.reqest.GetCustomerRewardParam;
import com.retailer.reward.repositiry.CustomerJpaRepositoryI;
import com.retailer.reward.repositiry.RewardJpaRepositoryI;
import com.retailer.reward.repositiry.StockJpaRepositoryI;
import com.retailer.reward.repositiry.TransactionJpaRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionServiceI{
    private final TransactionJpaRepositoryI transactionRepository;
    private final StockJpaRepositoryI stockRepository;
    private final RewardJpaRepositoryI rewardRepository;
    private final CustomerJpaRepositoryI customerRepository;
    private final PointEstimatorI pointEstimator;
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Transaction createNewTransaction(CreateNewTransactionParam param) {
        //obtain customer entity from DB
        var customer = customerRepository.findById(param.CustomerIdentifier()).orElseThrow();
        //Obtain stock entity from DB
        var stock = stockRepository.findById(param.stockIdentifier()).orElseThrow();
        //calculate  total price
        Double totalPrice = stock.getUnitPrice() * param.quantity();

        var transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setStock(stock);
        transaction.setQuantity(param.quantity());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setTotalPrice(totalPrice);

        //commit transaction
        var savedTransaction = transactionRepository.save(transaction);

        //estimate reward
        var over100DollarPnt = pointEstimator.over100DollarPoint(totalPrice);
        var over50DollarPnt = pointEstimator.over50DollarPoint(totalPrice);
        var totalPoint = over50DollarPnt + over100DollarPnt;

        var reward = new Reward();
        reward.setCustomer(customer);
        reward.setTransaction(savedTransaction);
        reward.setTotalReward(totalPoint);
        reward.setRewardPer1Dollar(over100DollarPnt);
        reward.setRewardPer50Dollar(over50DollarPnt);
        rewardRepository.save(reward);

        return savedTransaction;
    }




}
