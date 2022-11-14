package com.retailer.reward.records.reqest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record CreateNewTransactionParam(
        @NotNull
        Long CustomerIdentifier,
        @NotNull
        Long stockIdentifier,
        @NotNull
        @Min(value = 1, message = "Quantity cant be less than 1")
        Integer quantity
){ }
