package com.app.tinderproyects.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;

    private String name_project;

    private String description;

    @OneToOne
    @JoinColumn(name = "id_user_manager")
    private User userManager;

    @OneToMany(mappedBy = "project")
    private List<User> users;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Member> member;
}
