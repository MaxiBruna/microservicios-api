package com.pendiente.inscripcion_service.repository;

import com.pendiente.inscripcion_service.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscripcionRepository extends JpaRepository<Inscripcion, UUID> {
}