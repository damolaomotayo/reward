package com.retailer.reward.service;

import com.retailer.reward.records.reqest.GetCustomerRewardParam;
import com.retailer.reward.records.response.RewardResponse;

import java.util.List;

public interface RewardServiceI {
    List<RewardResponse> getRewards(GetCustomerRewardParam param);
}
