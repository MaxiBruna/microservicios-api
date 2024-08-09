package com.pendiente.alumnoservice.repository;

import com.pendiente.alumnoservice.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    Optional<Alumno> findAlumnoById(Long id);
    Optional<Alumno> findAlumnoByEmail(String dni);
    Boolean existsAlumnosById(Long id);
    //TODO: IMPLEMENTAR CONSULTA DINAMICA
}
