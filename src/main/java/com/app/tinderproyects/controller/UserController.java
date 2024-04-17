package com.app.tinderproyects.controller;

import com.app.tinderproyects.dtos.user.UserDto;
import com.app.tinderproyects.dtos.user.UserResponseDto;
import com.app.tinderproyects.entity.User;
import com.app.tinderproyects.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> allUser(){
        return ResponseEntity.ok(userService.allUser());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long idUser){
        return ResponseEntity.of(userService.findUserById(idUser));
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
