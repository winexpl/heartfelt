package com.app.heartfelt.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, SUFFERY, PSYCHOLOG;

    @Override
    public String getAuthority() {
        StringBuilder b = new StringBuilder();
        return  b.append("ROLE_").append(toString()).toString();
    }
}
