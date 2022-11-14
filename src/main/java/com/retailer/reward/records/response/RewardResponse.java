package com.retailer.reward.records.response;

public record RewardResponse(
        Integer rewardPer1Dollar,
        Integer rewardPer50Dollar,
        Integer totalReward,
        Integer quantity,
        Double totalPrice,
        String item
) {
}
