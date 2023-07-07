package com.example.PaymentGateway.service;

import com.example.PaymentGateway.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface TransactionService {
    public Transaction addTransaction( int userId,  int amount, int pin) throws Exception;

    void deleteFailedTransaction();
}
