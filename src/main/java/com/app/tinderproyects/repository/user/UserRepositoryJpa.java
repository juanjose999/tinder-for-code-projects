package com.app.tinderproyects.repository.user;

import com.app.tinderproyects.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password_hash= ?2")
    User findUserByEmailAndPasswordHash(String email, String passwordHash);

}
