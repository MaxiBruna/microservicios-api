package com.pendiente.materia_service.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ActualizarMateriaDto {
    UUID idMateria;
    String nombre;
}
