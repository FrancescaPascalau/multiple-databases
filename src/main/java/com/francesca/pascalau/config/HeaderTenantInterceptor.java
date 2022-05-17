package com.francesca.pascalau.config;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class HeaderTenantInterceptor implements WebRequestInterceptor {

    private static final String TENANT_HEADER = "X-TenantID";

    /**
     * 1. When a request is intercepted by the application, the header is checked, so we can set the current tenant_id
     *
     * @param request the current web request
     */
    @Override
    public void preHandle(WebRequest request) {
        TenantContext.setCurrentTenant(request.getHeader(TENANT_HEADER));
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) {
        TenantContext.clear();
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) {

    }
}
