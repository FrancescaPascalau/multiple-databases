package com.francesca.pascalau.domain.service;

import com.francesca.pascalau.data.repositories.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository repository;
}
