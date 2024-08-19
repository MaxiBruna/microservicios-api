package com.pendiente.materia_service.repository;

import com.pendiente.materia_service.model.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface MateriaRepository extends JpaRepository<Materia, UUID>, JpaSpecificationExecutor<Materia> {
}