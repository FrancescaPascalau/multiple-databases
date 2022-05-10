package com.francesca.pascalau.data.repositories;

import com.francesca.pascalau.data.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, String> {
}
