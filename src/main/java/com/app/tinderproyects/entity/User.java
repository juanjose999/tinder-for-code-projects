package com.app.tinderproyects.entity;
import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(length = (48), nullable = false)
    private String user_name;
    @Column(length = (48), nullable = false)
    private String password_hash;
    @Column(length = (48), nullable = false)
    private String email;
    @OneToOne
    @JoinColumn(name = "id_manager")
    private Manager manager;
    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

}
