package com.example.PaymentGateway.service.impl;

import com.example.PaymentGateway.model.Transaction;
import com.example.PaymentGateway.model.User;
import com.example.PaymentGateway.repository.TransactionRepository;
import com.example.PaymentGateway.repository.UserRepository;
import com.example.PaymentGateway.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Transaction addTransaction(int userId, int amount,int pin) throws Exception {
        // check user
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new Exception("User Not Found");
        }

        User user = optionalUser.get();

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDateAndTime(new Date());

        // check correct pin

        if(user.getPin() == pin){
            transaction.setStatus(true);
            transaction.setAmountDetucted(true);
        }

        user.getTransactionList().add(transaction);
        userRepository.save(user);
        return transactionRepository.save(transaction);

    }

    @Override
    public void deleteFailedTransaction() {

        for(User user : userRepository.findAll()){
            for(Transaction transaction : user.getTransactionList()){
                if(transaction.isStatus()==false){
                    transactionRepository.delete(transaction);
                }
            }
        }

    }
}
