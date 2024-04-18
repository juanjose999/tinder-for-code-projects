package com.app.tinderproyects.repository.user;

import com.app.tinderproyects.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> allUser();
    Optional<User> findUserById(Long id);
    User findUserByEmailAndPassword_hash(String email, String passwordHash);
    User saveUser(User user);
    User updateUser(Long id, User user);
    Boolean deleteUserById(Long id);
}
