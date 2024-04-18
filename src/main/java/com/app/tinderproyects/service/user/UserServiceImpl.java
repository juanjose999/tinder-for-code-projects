package com.app.tinderproyects.service.user;

import com.app.tinderproyects.dtos.user.UserDto;
import com.app.tinderproyects.dtos.user.UserMapper;
import com.app.tinderproyects.dtos.user.UserResponseDto;
import com.app.tinderproyects.entity.User;
import com.app.tinderproyects.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> allUser() {
        List<UserResponseDto> userListDto = new ArrayList<>();
        userRepository.allUser().forEach(u -> userListDto.add(UserMapper.userToUserResponseDto(u)));
        return userListDto;
    }

    @Override
    public Optional<UserResponseDto> findUserById(Long id) {
        User findUser = userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("Error in find user by id: " + id));
        return Optional.of(UserMapper.userToUserResponseDto(findUser));
    }

    @Override
    public UserResponseDto findByEmailAndPasswordHash(String email, String password) {
        return UserMapper.userToUserResponseDto(userRepository.findUserByEmailAndPassword_hash(email, password));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.saveUser(UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public UserResponseDto updateUser(Long id, UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.updateUser(id, UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }
}
