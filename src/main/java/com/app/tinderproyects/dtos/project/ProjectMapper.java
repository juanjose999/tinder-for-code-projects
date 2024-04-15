package com.app.tinderproyects.dtos.project;

import com.app.tinderproyects.entity.Project;

public class ProjectMapper {

    public static Project projectDtoToProject(ProjectDto projectDto){
        Project project = new Project();
        project.setName_project(projectDto.getName_project());
        project.setDescription(projectDto.getDescription());
        project.setManagerProject(projectDto.getManagerProject());
        project.setUserList(projectDto.getUserList());
        return project;
    }

    public static ProjectResponseDto projectToProjectResponseDto(Project project){
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId_project(project.getId_project());
        projectResponseDto.setName_project(project.getName_project());
        projectResponseDto.setDescription(project.getDescription());
        projectResponseDto.setManagerProject(project.getManagerProject());
        projectResponseDto.setUserList(project.getUserList());
        return projectResponseDto;
    }

}
