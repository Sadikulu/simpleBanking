package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentRepository extends JpaRepository<BillPayment,Long> {
}
