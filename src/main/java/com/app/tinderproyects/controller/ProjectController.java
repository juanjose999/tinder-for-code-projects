package com.app.tinderproyects.controller;

import com.app.tinderproyects.dtos.project.ProjectDto;
import com.app.tinderproyects.dtos.project.ProjectResponseDto;
import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class ProjectController {

    public final ProjectService projectService;

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDto>> allProjects(@PageableDefault(size = 1) Pageable pageable){
        return ResponseEntity.ok(projectService.allProjects(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectResponseDto> findProjectById(@PathVariable Long id){
        return ResponseEntity.of(projectService.findProjectById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ProjectResponseDto> saveProjectById(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.saveProject(projectDto));
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<ProjectResponseDto> saveWithProject(@PathVariable Long idUser, @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.saveProjectWithUser(idUser, projectDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.updateProject(id, projectDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProjectById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.deleteProjectById(id));
    }

}
