package com.francesca.pascalau.config;

import org.springframework.context.annotation.Configuration;

/**
 * This class is used to store the tenant Identifier for each request
 */
@Configuration
public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}