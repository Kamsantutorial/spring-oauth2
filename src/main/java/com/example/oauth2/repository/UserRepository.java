package com.example.oauth2.repository;

import com.example.oauth2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author KAMSAN TUTORIAL
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
