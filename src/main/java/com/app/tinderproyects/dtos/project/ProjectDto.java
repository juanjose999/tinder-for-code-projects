package com.app.tinderproyects.dtos.project;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {
    private String name_project;

    private String description;

    private List<User> project_user_list;

    public ProjectDto(String name_project, String description, List<User> project_user_list) {
        this.name_project = name_project;
        this.description = description;
        this.project_user_list = project_user_list;
    }
}
