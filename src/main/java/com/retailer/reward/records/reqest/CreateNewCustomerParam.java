package com.retailer.reward.records.reqest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateNewCustomerParam(
        @NotNull
        String name,
        @Email
        String email,
        @NotNull
        String shippingAddress
) {
}
