package com.bartrip.main.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.bartrip.main.entity.User.User;

public class SecurityAuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .map(Authentication::getPrincipal)
        .map(principal->{
            if (principal==null) return "nologged";
            if (principal instanceof String){
                return (String) principal;
            }
            return ((User) principal).getId()+"";
        });
    }
    
}
