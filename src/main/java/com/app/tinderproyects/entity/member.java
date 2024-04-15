package com.app.tinderproyects.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class member {
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
