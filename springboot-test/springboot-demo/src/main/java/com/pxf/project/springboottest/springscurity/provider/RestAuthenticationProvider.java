package com.pxf.project.springboottest.springscurity.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**  
* 自定义provider
*/
public class RestAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}