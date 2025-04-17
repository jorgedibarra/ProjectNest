package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles_proyecto")
public class RolProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_proyecto")
    private Long idRolProyecto;

    @Column(nullable = false, length = 20, unique = true)
    private String nombreRol;

    private String descripcion;

    @Column(nullable = false)
    private Integer nivel_permiso;

    @OneToMany(mappedBy = "rolProyecto")
    private List<MiembroProyecto> miembrosProyecto;
}
