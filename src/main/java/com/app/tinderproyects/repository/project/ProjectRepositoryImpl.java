package com.app.tinderproyects.repository.project;

import com.app.tinderproyects.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectRepositoryJpa projectRepositoryJpa;

    @Override
    public List<Project> allProjects() {
        return projectRepositoryJpa.findAll();
    }

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectRepositoryJpa.findById(id);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepositoryJpa.save(project);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Optional<Project> findProject = findProjectById(id);
        if(findProject.isPresent()){
            Project existingProject = findProject.get();
            existingProject.setName_project(project.getName_project());
            existingProject.setDescription(project.getDescription());
            existingProject.setUserList(project.getUserList());
            return projectRepositoryJpa.save(existingProject);
        }
        throw new RuntimeException("Error in save project.");
    }

    @Override
    public Boolean deleteProjectById(Long id) {
        Optional<Project> findProject = findProjectById(id);
        if(findProject.isPresent()){
            projectRepositoryJpa.delete(findProject.get());
            return true;
        }else return false;
    }
}
