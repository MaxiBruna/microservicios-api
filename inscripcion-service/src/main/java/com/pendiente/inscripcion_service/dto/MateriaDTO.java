package com.pendiente.inscripcion_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriaDTO {
    private UUID id;
    private List<Long> ProfesoresIds;
}
