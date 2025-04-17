package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"proyecto", "usuario"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "miembros_proyecto")
public class MiembroProyecto {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private MiembroProyectoPk idMiembroProyecto;

    @Column(name = "fecha_union", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaUnion;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolProyecto rolProyecto;

    @ManyToOne
    @MapsId("idProyecto")
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
