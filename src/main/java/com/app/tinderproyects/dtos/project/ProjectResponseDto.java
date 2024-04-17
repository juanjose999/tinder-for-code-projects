package com.app.tinderproyects.dtos.project;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ProjectResponseDto {
    private Long id_project;

    private String name_project;

    private String description;

    private List<User> userList;

    public ProjectResponseDto(Long id_project, String name_project, String description, List<User> userList) {
        this.id_project = id_project;
        this.name_project = name_project;
        this.description = description;
        this.userList = userList;
    }
}
