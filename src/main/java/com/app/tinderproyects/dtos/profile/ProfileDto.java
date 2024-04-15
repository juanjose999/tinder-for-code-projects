package com.app.tinderproyects.dtos.profile;

import com.app.tinderproyects.entity.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDto {
    private Project id_project;

    private Project name;

    private Project description;

    private Long id_manager;
}
