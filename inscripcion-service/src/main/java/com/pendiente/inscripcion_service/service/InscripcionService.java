package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.InscripcionDTO;
import com.pendiente.inscripcion_service.entity.Inscripcion;

import java.util.UUID;

public interface InscripcionService {
    Inscripcion crearInscripcion(InscripcionDTO inscripcionDTO);
    Inscripcion encontrarPorId(UUID id);
    Inscripcion actualuzarInscripcion(InscripcionDTO inscripcionDTO, UUID id);
}
