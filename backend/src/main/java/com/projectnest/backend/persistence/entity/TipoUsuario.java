package com.projectnest.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipos_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    @Column(nullable = false, unique = true, length = 20)
    private String nombreTipo;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
}
