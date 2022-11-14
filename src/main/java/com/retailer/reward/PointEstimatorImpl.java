package com.retailer.reward;

import org.springframework.stereotype.Component;

@Component
public class PointEstimatorImpl implements PointEstimatorI{

    @Override
    public int over100DollarPoint(Double amount) {
        Double excess = amount-100.00;
        if(excess >0){
            return 2 * excess.intValue();
        }else{
            return 0;
        }
    }

    @Override
    public int over50DollarPoint(Double amount) {
        Double excess = amount-50.00;
        if(excess >0){
            return 1 * excess.intValue();
        }else{
            return 0;
        }
    }
}
