package com.app.tinderproyects.dtos.user;

import com.app.tinderproyects.entity.User;

public class UserMapper {

    public static User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setUser_name(userDto.getUser_name());
        user.setPassword_hash(userDto.getPassword_hash());
        user.setEmail(userDto.getEmail());
        user.setProject(userDto.getProject());
        user.setManager(userDto.getManager());
        return user;
    }

    public static UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUser_name(user.getUser_name());
        userResponseDto.setPassword_hash(userResponseDto.getPassword_hash());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setProject(user.getProject());
        userResponseDto.setManager(user.getManager());
        return userResponseDto;
    }

}
