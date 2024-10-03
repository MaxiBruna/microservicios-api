package com.pendiente.inscripcion_service.entity;

import com.pendiente.inscripcion_service.enums.Estados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name ="id_alumnos")
    private Long idAlumno;
    @Column(name = "id_materias")
    private UUID idMateria;
    @Column(name = "id_profesores")
    private Long idProfesor;
    @Enumerated(EnumType.STRING)
    private Estados estado;
    @Column(nullable = false)
    private LocalDate fecha;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDate.now();
    }
}
