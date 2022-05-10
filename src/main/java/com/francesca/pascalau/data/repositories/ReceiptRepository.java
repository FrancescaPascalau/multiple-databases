package com.francesca.pascalau.data.repositories;

import com.francesca.pascalau.data.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
