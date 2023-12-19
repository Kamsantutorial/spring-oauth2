package com.example.oauth2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
/**
 * @author KAMSAN TUTORIAL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String roleName;
    private String description;

    public String getRoleName() {
        return roleName.replace("ROLE_", "");
    }

    public void setRoleName(String roleName) {
        this.roleName = String.format("ROLE_%s", roleName);
    }
}
