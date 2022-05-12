package com.francesca.pascalau.config.database;

import com.francesca.pascalau.config.TenantContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 2. Handling the request based on the tenant_id
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }
}