package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	public Page<Payment> findByPaymentId(Long paymentId, Pageable pageable);

}
