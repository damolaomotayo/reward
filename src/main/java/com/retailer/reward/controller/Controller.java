package com.retailer.reward.controller;

import com.retailer.reward.records.reqest.*;
import com.retailer.reward.service.CustomerServiceI;
import com.retailer.reward.service.RewardServiceI;
import com.retailer.reward.service.StockServiceI;
import com.retailer.reward.service.TransactionServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class Controller {
    private final CustomerServiceI customerServiceI;
    private final StockServiceI stockServiceI;

    private final TransactionServiceI transactionServiceI;
    private final RewardServiceI rewardServiceI;

    @GetMapping("/reward")
    public ResponseEntity<?> getRewards(@RequestBody GetCustomerRewardParam param){
        return new ResponseEntity<>(rewardServiceI.getRewards(param),HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> createNewCustomer(@RequestBody @Valid CreateNewCustomerParam param, BindingResult br){
        if(!br.hasErrors()){
            customerServiceI.createNewCustomer(param);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            throw new ValidationException("One or more field is invalid");
        }
    }

    @PostMapping("/stock")
    public ResponseEntity<?> createNewCustomer(@RequestBody @Valid CreateNewStock param, BindingResult br){
        if(!br.hasErrors()){
            stockServiceI.createNewStock(param);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            throw new ValidationException("One or more field is invalid");
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> createNewTransaction(@RequestBody @Valid CreateNewTransactionParam param, BindingResult br){
        if(!br.hasErrors()){
            transactionServiceI.createNewTransaction(param);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            throw new ValidationException("One or more field is invalid");
        }
    }
}
