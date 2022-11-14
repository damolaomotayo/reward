package com.retailer.reward.service;

import com.retailer.reward.entity.Stock;
import com.retailer.reward.records.reqest.CreateNewStock;
import com.retailer.reward.repositiry.StockJpaRepositoryI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class StockServiceImplTest {
    @Mock
    StockJpaRepositoryI stockRepositoryI;
    @InjectMocks
    StockServiceImpl stockService;

    @BeforeAll
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Washing Machine","Blender","Cigar"})
    public void createNewStock(String item){
        when(stockRepositoryI.save(any(Stock.class))).thenAnswer(invocation->{
            var stock = invocation.getArgument(0,Stock.class);
            stock.setId(1L);
            return stock;
        });
        var result = stockService.createNewStock(new CreateNewStock(
                item,150.00
        ));
        assertEquals("Item name is not equal",result.getItem(),item);
    }
}
