package com.app.tinderproyects.dtos.user;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String user_name;

    private String password_hash;

    private String email;

    private Manager manager;

    private Project project;

    public UserResponseDto(Long id,String user_name, String password_hash, String email, Manager manager, Project project) {
        this.id=id;
        this.user_name = user_name;
        this.password_hash = password_hash;
        this.email = email;
        this.manager = manager;
        this.project = project;
    }
}
