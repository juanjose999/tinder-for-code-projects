package com.app.tinderproyects.entity;

import jakarta.persistence.*;

@Entity
public class Project_member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_members;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
