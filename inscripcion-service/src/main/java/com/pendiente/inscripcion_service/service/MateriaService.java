package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.MateriaDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface MateriaService {
    MateriaDTO verificarMateria(UUID id);
}
