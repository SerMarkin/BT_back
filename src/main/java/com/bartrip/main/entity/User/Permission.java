package com.bartrip.main.entity.User;

public enum Permission {
    CUSTOMER_READ("customer:read"),
    ADMIN_WRITE("admin:write"),
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    private final String permission;

    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
