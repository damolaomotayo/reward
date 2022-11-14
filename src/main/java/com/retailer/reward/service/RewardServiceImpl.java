package com.retailer.reward.service;

import com.retailer.reward.records.reqest.GetCustomerRewardParam;
import com.retailer.reward.records.response.RewardResponse;
import com.retailer.reward.repositiry.RewardRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardServiceI{
    private final RewardRepositoryI rewardRepository;

    @Override
    @Transactional
    public List<RewardResponse> getRewards(GetCustomerRewardParam param) {
        return rewardRepository.getCustomerReward(param).stream().map(

                reward -> {
                    var customer = reward.getCustomer();
                    var transaction = reward.getTransaction();
                    var stock = transaction.getStock();
                    return new RewardResponse(reward.getRewardPer1Dollar(), reward.getRewardPer50Dollar(),
                            reward.getTotalReward(), transaction.getQuantity(),
                            transaction.getTotalPrice(),stock.getItem());
                }
        ).collect(Collectors.toList());
    }
}
