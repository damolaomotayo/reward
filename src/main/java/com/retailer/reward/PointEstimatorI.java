package com.retailer.reward;

public interface PointEstimatorI {
    int over100DollarPoint(Double amount);
    int over50DollarPoint(Double amount);
}
