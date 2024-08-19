package com.pendiente.materia_service.model.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriaDto{
    String nombre;
    Long profesorId;
}