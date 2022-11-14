package com.retailer.reward;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class PointEstimatorTest {

    @InjectMocks
    private PointEstimatorImpl pointEstimator;

    @BeforeAll
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(doubles = {120.00,750.00,700.00})
    public void over100DollarPointTest(Double amount){
        var pnt = pointEstimator.over100DollarPoint(amount);
        Double excess = (amount-100);
        assertEquals("point is incorrect", pnt, excess.intValue()*2);
    }

    @ParameterizedTest
    @ValueSource(doubles = {70.00,40.00,10.00})
    public void less100DollarPointTest(Double amount){
        var pnt = pointEstimator.over100DollarPoint(amount);
        assertEquals("point is incorrect", pnt, 0);
    }
}
