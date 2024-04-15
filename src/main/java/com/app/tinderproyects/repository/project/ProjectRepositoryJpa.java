package com.app.tinderproyects.repository.project;

import com.app.tinderproyects.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjectRepositoryJpa extends JpaRepository<Project, Long> {
}
