package com.pendiente.inscripcion_service.dto;

import com.pendiente.inscripcion_service.enums.Estados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscripcionDTO {

    private Long idAlumno;
    private UUID idMateria;
    private Long idProfesor;
    private Estados estado;
}
