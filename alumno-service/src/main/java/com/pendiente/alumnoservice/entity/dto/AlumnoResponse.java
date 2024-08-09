package com.pendiente.alumnoservice.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.pendiente.alumnoservice.entity.Alumno}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlumnoResponse {
    Long id;
    String nombre;
    String email;
}