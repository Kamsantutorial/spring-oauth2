package com.example.oauth2.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
/**
 * @author KAMSAN TUTORIAL
 */
@Entity
@Getter
@Setter
@Table(name = "role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "role_name")
    private String roleName;
    private String description;

    @Override
    public String getAuthority() {
        return roleName;
    }
}