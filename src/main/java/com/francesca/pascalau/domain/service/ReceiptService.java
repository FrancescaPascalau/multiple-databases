package com.francesca.pascalau.domain.service;

import com.francesca.pascalau.data.repositories.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final ReceiptRepository repository;
}
