package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prioridades_tarea")
public class PrioridadTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prioridad_tarea")
    private Long idPrioridadTarea;

    @Column(nullable = false, length = 20, unique = true)
    private String nombrePrioridad;

    @Column(nullable = false, unique = true)
    private Integer nivelGravedad;

    @OneToMany(mappedBy = "prioridad")
    private List<Tarea> tareas;
}
