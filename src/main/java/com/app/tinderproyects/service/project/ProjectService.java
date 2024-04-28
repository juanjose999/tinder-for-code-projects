package com.app.tinderproyects.service.project;

import com.app.tinderproyects.dtos.project.ProjectDto;
import com.app.tinderproyects.dtos.project.ProjectResponseDto;
import com.app.tinderproyects.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Page<ProjectResponseDto> allProjects(Pageable pageable);
    Optional<ProjectResponseDto> findProjectById(Long id);
    ProjectResponseDto saveProject(ProjectDto projectDto);
    ProjectResponseDto saveProjectWithUser(Long idUser, ProjectDto projectDto);

    ProjectResponseDto updateProject(Long id, ProjectDto projectDto);
    Boolean deleteProjectById(Long id);
}
