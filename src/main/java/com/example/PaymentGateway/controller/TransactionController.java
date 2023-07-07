package com.example.PaymentGateway.controller;

import com.example.PaymentGateway.model.Transaction;
import com.example.PaymentGateway.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;

    @PostMapping("/add")
    public ResponseEntity addTransaction(@RequestParam("userId") int userId,@RequestParam("amount") int amount,@RequestParam("pin") int pin){
        try{
            Transaction transaction = transactionService.addTransaction(userId,amount,pin);
            return new ResponseEntity(transaction,HttpStatus.CREATED);  // Dto will be used
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-failed-transaction")
    public ResponseEntity deleteFailedTransaction(){
        transactionService.deleteFailedTransaction();
        return new ResponseEntity("All Failed Transaction is deleted",HttpStatus.ACCEPTED);
    }

}
