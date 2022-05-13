package com.francesca.pascalau.config;

import org.springframework.context.annotation.Configuration;

/**
 * This class is used to store the tenant Identifier for each request
 */
@Configuration
public class TenantContext {

    public final static String DEFAULT = "public";
    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    /**
     * 3. Find the current tenant_id that was set before handling the current request
     *
     * @return
     */
    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}