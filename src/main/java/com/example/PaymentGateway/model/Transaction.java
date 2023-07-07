package com.example.PaymentGateway.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transactionId;

    int amount;

    boolean status;

    boolean amountDetucted;

    Date dateAndTime; // util -> date and time

    @ManyToOne
    @JoinColumn
    User user;


}
