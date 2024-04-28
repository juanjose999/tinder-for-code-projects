package com.app.tinderproyects.dtos.user;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String user_name;

    private String password_hash;

    private String email;

    private Project project;

    public UserDto(String user_name, String password_hash, String email) {
        this.user_name = user_name;
        this.password_hash = password_hash;
        this.email = email;
        this.project = null;
    }
}
