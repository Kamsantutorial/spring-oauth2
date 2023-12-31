package com.example.oauth2.dto;

import com.example.oauth2.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

/**
 * @author KAMSAN TUTORIAL
 */

@Getter
@Setter
public class UserBasicDTO extends User {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String username;
    private String password;

    public UserBasicDTO(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getRoles());
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
