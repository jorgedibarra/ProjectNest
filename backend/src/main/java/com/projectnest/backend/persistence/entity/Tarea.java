package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long idTarea;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaActualizacion;

    private LocalDateTime fechaFinalizacion;
    private LocalDate fechaLimite;

    @ManyToOne
    @JoinColumn(name = "id_prioridad")
    private PrioridadTarea prioridad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoTarea estado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario creador;

    @ManyToOne
    @JoinColumn(name = "id_asignado")
    private Usuario asignado;

    @OneToMany(mappedBy = "tarea")
    private List<ComentarioTarea> comentarios;

    @OneToMany(mappedBy = "tarea")
    private List<HistorialTarea> historiales;
}
