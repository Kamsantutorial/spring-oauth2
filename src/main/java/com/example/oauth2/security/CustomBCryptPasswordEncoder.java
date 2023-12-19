package com.example.oauth2.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author KAMSAN TUTORIAL
 */
@Component
public class CustomBCryptPasswordEncoder extends BCryptPasswordEncoder {

    public CustomBCryptPasswordEncoder() {
        super();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return super.matches(rawPassword, encodedPassword);
    }
}
