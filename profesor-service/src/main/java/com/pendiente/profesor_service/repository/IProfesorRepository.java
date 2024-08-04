package com.pendiente.profesor_service.repository;

import com.pendiente.profesor_service.domain.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepository extends JpaRepository<ProfesorEntity,Long> {

    ProfesorEntity getProfesorEntitiesByDni(String dni);
    ProfesorEntity searchByDni(String dni);
}
