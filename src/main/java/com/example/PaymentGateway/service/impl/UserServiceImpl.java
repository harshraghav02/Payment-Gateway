package com.example.PaymentGateway.service.impl;

import com.example.PaymentGateway.model.Refund;
import com.example.PaymentGateway.model.Transaction;
import com.example.PaymentGateway.model.User;
import com.example.PaymentGateway.repository.RefundRepository;
import com.example.PaymentGateway.repository.UserRepository;
import com.example.PaymentGateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RefundRepository refundRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public int getTotalSuccessfullTransaction(int userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new Exception("User Not Found"); // custom exception
        }

        User user = optionalUser.get();

        int totalSuccessTransaction = 0;

        for(Transaction transaction : user.getTransactionList()){
            if(transaction.isStatus())
                totalSuccessTransaction++;
        }

        return totalSuccessTransaction;
    }

    @Override
    public int getUserMaxRefund() {
        int userId = 0;
        int maxRefund = -1;

        for(Refund refund : refundRepository.findAll()){
            if(maxRefund<refund.getAmount()){
                maxRefund = refund.getAmount();
                userId = refund.getUserId();
            }
        }
        return userId;
    }
}
