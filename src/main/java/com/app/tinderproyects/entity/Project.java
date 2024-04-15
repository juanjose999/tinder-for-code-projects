package com.app.tinderproyects.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;

    @Column(length = (68), nullable = false)
    private String name_project;

    private String description;

    @OneToOne
    @JoinColumn(name = "id_manager")
    private Manager managerProject;

    @OneToMany(mappedBy = "project")
    private List<User> userList;

}