package com.pendiente.profesor_service.domain.dto;

import com.pendiente.profesor_service.domain.entity.ProfesorEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link ProfesorEntity}
 */
@Value
@Data
@Builder
public class ProfesorRequest{
    String nombre;
    String dni;
    String telefono;
    String email;
    String direccion;
    String localidad;
    Date fechaNacimiento;
}