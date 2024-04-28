package com.app.tinderproyects.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(length = (40), nullable = false)
    private String user_name;
    @Column(length = (240), nullable = false)
    private String password_hash;
    @Column(length = (40), nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")
    )
    private Collection<Rol> roles = Arrays.asList(new Rol("ROLE_USER"));

    @OneToOne(mappedBy = "userManager")
    private Project userManager;


}
