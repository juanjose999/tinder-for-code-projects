package com.app.tinderproyects.service.user;

import com.app.tinderproyects.dtos.user.UserDto;
import com.app.tinderproyects.dtos.user.UserResponseDto;
import com.app.tinderproyects.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> allUser();
    Optional<UserResponseDto> findUserById(Long id);
    UserResponseDto saveUser(UserDto userDto);
    UserResponseDto updateUser(Long id, UserDto userDto);
    Boolean deleteUserById(Long id);
}
