package com.app.tinderproyects.dtos.manager;

import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDto {
    private Long id_manager;
    private User user;
    private Project project;
}
