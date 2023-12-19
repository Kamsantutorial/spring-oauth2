package com.example.oauth2.service;



import com.example.oauth2.dto.UserBasicDTO;
import com.example.oauth2.entity.UserEntity;
import com.example.oauth2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author KAMSAN TUTORIAL
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity example = new UserEntity();
            example.setUsername(username);
            UserEntity userEntity =  this.userRepository.findOne(Example.of(example)).orElse(null);
            if (Objects.isNull(userEntity)) {
                throw new UsernameNotFoundException(String.format("User %s was not found in the database",username));
            }
            return new UserBasicDTO(userEntity);
        } catch (Exception e) {
            log.error("Error user", e);
            throw new UsernameNotFoundException(String.format("User %s was not found in the database",username));
        }
    }

}
