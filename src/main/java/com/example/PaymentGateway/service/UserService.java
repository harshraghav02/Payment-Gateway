package com.example.PaymentGateway.service;

import com.example.PaymentGateway.model.User;

public interface UserService {
    public User addUser(User user);

    int getTotalSuccessfullTransaction(int userId) throws Exception;

    int getUserMaxRefund();
}
