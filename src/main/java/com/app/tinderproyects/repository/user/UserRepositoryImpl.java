package com.app.tinderproyects.repository.user;

import com.app.tinderproyects.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository{

    private final UserRepositoryJpa userRepositoryJpa;
    @Override
    public List<User> allUser() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepositoryJpa.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> findUser = findUserById(id);
        if(findUser.isPresent()){
            User existingUser = findUser.get();
            existingUser.setUser_name(user.getUser_name());
            existingUser.setPassword_hash(user.getPassword_hash());
            existingUser.setEmail(user.getEmail());
            existingUser.setProject(user.getProject());
            return userRepositoryJpa.save(existingUser);
        }
        throw new RuntimeException("Error in update user.");
    }

    @Override
    public Boolean deleteUserById(Long id) {
        Optional<User> user = findUserById(id);
        if(user.isPresent()){
            userRepositoryJpa.delete(user.get());
            return true;
        }else return false;
    }
}
