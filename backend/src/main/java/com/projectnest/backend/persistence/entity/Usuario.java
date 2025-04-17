package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true, length = 50)
    private String nombreUsuario;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 100)
    private String contrasena;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Proyecto> proyectos;

    @OneToMany(mappedBy = "usuario")
    private List<MiembroProyecto> miembrosProyectos;

    @OneToMany(mappedBy = "usuario")
    private List<ComentarioTarea> comentariosTareas;

    @OneToMany(mappedBy = "usuario")
    private List<HistorialTarea> historialesTareas;

    @OneToMany(mappedBy = "creador")
    private List<Tarea> tareasCreadas;

    @OneToMany(mappedBy = "asignado")
    private List<Tarea> tareasAsignadas;
}
