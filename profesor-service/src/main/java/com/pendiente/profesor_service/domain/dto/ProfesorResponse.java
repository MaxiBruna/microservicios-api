package com.pendiente.profesor_service.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.pendiente.profesor_service.domain.entity.ProfesorEntity}
 */
@Value
@Data
@Builder
public class ProfesorResponse {
    Long id;
    String nombre;
    String dni;
    String telefono;
    String email;
    String direccion;
    String localidad;
    Date fechaNacimiento;
}