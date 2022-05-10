package com.francesca.pascalau.domain.service;

import com.francesca.pascalau.data.entities.Payment;
import com.francesca.pascalau.data.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    /**
     * Since the creation of the class AbstractBaseEntity which contains the tenantId Filter
     * that will be applied at Runtime on all entities that extends it.
     */
    public List<Payment> findPayments() {
        return repository.findAll();
    }

    public Payment save(Payment payment) {
        return repository.save(payment);
    }
}
