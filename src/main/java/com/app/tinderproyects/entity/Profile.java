package com.app.tinderproyects.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profile;

    @OneToOne
    @JoinColumn(name = "id_project")
    private Project id_project;

    private String name;

    private String description;

    private Long id_manager;

}


