package com.app.tinderproyects.service.project;

import com.app.tinderproyects.dtos.project.ProjectDto;
import com.app.tinderproyects.dtos.project.ProjectMapper;
import com.app.tinderproyects.dtos.project.ProjectResponseDto;
import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectResponseDto> allProjects() {
        List<ProjectResponseDto> projectResponseDtoList = new ArrayList<>();
        projectRepository.allProjects().forEach(project -> projectResponseDtoList.add(ProjectMapper.projectToProjectResponseDto(project)));
        return projectResponseDtoList;
    }

    @Override
    public Optional<ProjectResponseDto> findProjectById(Long id) {
        Project findProject = projectRepository.findProjectById(id).orElseThrow(()-> new RuntimeException("Error in find priject by id: " + id));
        return Optional.of(ProjectMapper.projectToProjectResponseDto(findProject));
    }

    @Override
    public ProjectResponseDto saveProject(ProjectDto projectDto) {
        return ProjectMapper.projectToProjectResponseDto(projectRepository.saveProject(ProjectMapper.projectDtoToProject(projectDto)));
    }

    @Override
    public ProjectResponseDto saveProjectWithUser(Long idUser, ProjectDto projectDto) {
        return ProjectMapper.projectToProjectResponseDto(projectRepository.saveProjectWithUser(idUser, ProjectMapper.projectDtoToProject(projectDto)));
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectDto projectDto) {
        return ProjectMapper.projectToProjectResponseDto(projectRepository.updateProject(id, ProjectMapper.projectDtoToProject(projectDto)));
    }

    @Override
    public Boolean deleteProjectById(Long id) {
        return projectRepository.deleteProjectById(id);
    }
}
