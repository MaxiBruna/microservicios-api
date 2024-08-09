package com.pendiente.alumnoservice.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.pendiente.alumnoservice.entity.Alumno}
 */
@Builder
@Data
@AllArgsConstructor
public class AlumnoRequest {
    private Long id;
    private String nombre;
    private String email;
}