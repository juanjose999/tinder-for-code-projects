package com.app.tinderproyects.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ProjectProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profile;

    @OneToOne
    @JoinColumn(name = "id_project")
    private Project id_project;

    private Project name;

    private Project description;

    private Long id_manager;


}


