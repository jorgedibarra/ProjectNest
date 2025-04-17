package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "estados_proyecto")
public class EstadoProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_proyecto")
    private Long idEstadoProyecto;

    @Column(nullable = false, length = 20)
    private String nombreEstado;

    @Column(nullable = false)
    private Integer ordenFlujo;

    @OneToMany(mappedBy = "estado")
    private List<Proyecto> proyectos;
}
