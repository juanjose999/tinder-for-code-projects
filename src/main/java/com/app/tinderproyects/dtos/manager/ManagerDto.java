package com.app.tinderproyects.dtos.manager;

import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
    private User user;
    private Project project;
}
