package com.example.oauth2.security;

import com.example.oauth2.dto.UserBasicDTO;
import com.example.oauth2.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

/**
 * @author KAMSAN TUTORIAL
 */
public class CustomAuthenticationManager implements AuthenticationManager {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationManager(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        UserBasicDTO userBasicDTO = (UserBasicDTO) this.userService.loadUserByUsername(username);
        if (userBasicDTO == null) {
            throw new BadCredentialsException("Incorrect username or password!");
        }
        if (!passwordEncoder.matches(password, userBasicDTO.getPassword())) {
            throw new BadCredentialsException("Incorrect username or password!");
        }
        Collection<GrantedAuthority> userRights = userBasicDTO.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userBasicDTO, null, userRights);
    }
}
