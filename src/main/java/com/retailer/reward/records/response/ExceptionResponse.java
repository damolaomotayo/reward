package com.retailer.reward.records.response;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        HttpStatus status,
        String message
) {
}
