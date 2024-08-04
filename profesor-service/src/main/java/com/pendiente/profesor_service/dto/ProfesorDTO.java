package com.pendiente.profesor_service.dto;

import com.pendiente.profesor_service.domain.ProfesorEntity;
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
public class ProfesorDTO implements Serializable {
    String nombre;
    String dni;
    String telefono;
    String email;
    String direccion;
    String numeroDomicilio;
    String localidad;
    Date fechaNacimiento;
}