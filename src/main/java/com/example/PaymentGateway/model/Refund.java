package com.example.PaymentGateway.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int refundId;
    int amount;


    int userId;

    int transactionId;
}
