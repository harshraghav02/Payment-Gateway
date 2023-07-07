package com.example.PaymentGateway.repository;

import com.example.PaymentGateway.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Integer> {
}
