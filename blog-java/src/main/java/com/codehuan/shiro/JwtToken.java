package com.codehuan.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ZhangHuan created on 2021/2/8
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
