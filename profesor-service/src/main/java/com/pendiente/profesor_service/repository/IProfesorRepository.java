package com.pendiente.profesor_service.repository;

import com.pendiente.profesor_service.domain.entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfesorRepository extends JpaRepository<ProfesorEntity,Long> {
    //TODO: IMPLEMENTAR CONSULTA DINAMICA
    Optional<ProfesorEntity> getProfesorEntitiesByDni(String dni);
    boolean existsByDni(String dni);

}
