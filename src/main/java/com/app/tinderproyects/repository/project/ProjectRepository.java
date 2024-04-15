package com.app.tinderproyects.repository.project;

import com.app.tinderproyects.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> allProjects();
    Optional<Project> findProjectById(Long id);
    Project saveProject(Project project);
    Project updateProject(Long id, Project project);
    Boolean deleteProjectById(Long id);
}
