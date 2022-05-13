package com.francesca.pascalau.config.database;

import com.francesca.pascalau.config.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 2. Handling the request based on the tenant_id
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String currentTenant = TenantContext.getCurrentTenant();
        log.info("Current tenant is: {}", currentTenant);

        return currentTenant != null ? currentTenant : TenantContext.DEFAULT;
    }
}