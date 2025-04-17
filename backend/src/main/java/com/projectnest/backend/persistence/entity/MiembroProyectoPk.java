package com.projectnest.backend.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class MiembroProyectoPk implements Serializable {

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "id_usuario")
    private Long idUsuario;
}
