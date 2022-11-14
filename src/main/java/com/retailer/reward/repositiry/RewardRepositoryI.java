package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Reward;
import com.retailer.reward.records.reqest.GetCustomerRewardParam;

import java.util.List;

public interface RewardRepositoryI {
    List<Reward> getCustomerReward(GetCustomerRewardParam param);
}
