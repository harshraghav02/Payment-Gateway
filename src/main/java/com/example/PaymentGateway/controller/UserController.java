package com.example.PaymentGateway.controller;

import com.example.PaymentGateway.model.User;
import com.example.PaymentGateway.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
        User savedUser = userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping("/get-total-successfull-transaction")
    public ResponseEntity getTotalSuccessfullTransaction(@RequestParam("userId") int userId){
        try{
            int total = userService.getTotalSuccessfullTransaction(userId);
            return new ResponseEntity(total, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-user-max-refund")
    public ResponseEntity getUserMaxRefund(){
        int userId = userService.getUserMaxRefund();
        return new ResponseEntity(userId, HttpStatus.FOUND);
    }
}
