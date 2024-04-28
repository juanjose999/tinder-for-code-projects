package com.app.tinderproyects.repository.project;

import com.app.tinderproyects.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Page<Project> allProjects(Pageable pageable);
    Optional<Project> findProjectById(Long id);
    Project saveProject(Project project);
    Project saveProjectWithUser(Long idUser, Project project);
    Project updateProject(Long id, Project project);
    Boolean deleteProjectById(Long id);
}
