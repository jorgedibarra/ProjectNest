package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "estados_tarea")
public class EstadoTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_tarea")
    private Long idEstadoTarea;

    @Column(nullable = false, length = 20, unique = true)
    private String nombreEstado;

    @Column(nullable = false)
    private Integer ordenFlujo;

    @OneToMany(mappedBy = "estado")
    private List<Tarea> tareas;
}
