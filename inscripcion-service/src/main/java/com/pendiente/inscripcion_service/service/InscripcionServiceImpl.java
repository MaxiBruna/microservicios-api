package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.AlumnoDTO;
import com.pendiente.inscripcion_service.dto.InscripcionDTO;
import com.pendiente.inscripcion_service.dto.MateriaDTO;
import com.pendiente.inscripcion_service.dto.ProfesorDTO;
import com.pendiente.inscripcion_service.entity.Inscripcion;
import com.pendiente.inscripcion_service.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class InscripcionServiceImpl implements InscripcionService {
    private final InscripcionRepository inscripcionRepository;
    private final AlumnoService alumnoService;
    private final MateriaService materiaService;
    private final ProfesorService profesorService;

    @Override
    public Inscripcion crearInscripcion(InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = new Inscripcion();
        MateriaDTO materia = crearDtoValidado(inscripcionDTO);
        setearListProfesoresId(inscripcionDTO, materia, inscripcion);
        inscripcion.setIdAlumno(inscripcionDTO.getIdAlumno());
        inscripcion.setIdMateria(inscripcionDTO.getIdMateria());
        inscripcion.setEstado(inscripcionDTO.getEstado());
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Inscripcion encontrarPorId(UUID id) {
        return inscripcionRepository.findById(id).orElseThrow();
    }

    @Override
    public Inscripcion actualuzarInscripcion(InscripcionDTO inscripcionDTO, UUID id) {
        Inscripcion inscripcion = new Inscripcion();
        var inscripcionExistente = inscripcionRepository.findById(id);
        if(inscripcionExistente.isEmpty()) {
            throw new RuntimeException("Inscripcion no encontrada");
        }
        inscripcion.setIdAlumno(inscripcionDTO.getIdAlumno());
        inscripcion.setIdMateria(inscripcionDTO.getIdMateria());
        inscripcion.setEstado(inscripcionDTO.getEstado());
        return inscripcionRepository.save(inscripcion);
    }

    private static void setearListProfesoresId(InscripcionDTO inscripcionDTO, MateriaDTO materia, Inscripcion inscripcion) {
        if(materia.getProfesoresIds().size() < 0 ){
            log.info("Materia con mas de 1 profesor, ");
            for (Long id : materia.getProfesoresIds()){
                if (id == inscripcionDTO.getIdProfesor()) {
                    inscripcion.setIdProfesor(inscripcionDTO.getIdProfesor());
                }
            }
        }
    }

    private MateriaDTO crearDtoValidado(InscripcionDTO inscripcionDTO) {
        log.info("Llamando a verificar materia alumno y profesor");
        AlumnoDTO alumno = alumnoService.verificarAlumno(inscripcionDTO.getIdAlumno());
        MateriaDTO materia = materiaService.verificarMateria(inscripcionDTO.getIdMateria());
        ProfesorDTO profesor = profesorService.verificarProfesor(inscripcionDTO.getIdProfesor());

        log.info("Evaluando profesor: " + profesor);
        if (profesor == null) {
            throw new RuntimeException("Profesor no puede ser null");
        }
        log.info("Evaluando materia" + materia);
        if (materia == null) {
            throw new RuntimeException("Materia no puede ser null");
        }
        log.info("Evaluando alumno" + alumno);
        if (alumno == null) {
            throw new RuntimeException("Alumno no puede ser null");
        }
        return materia;
    }
}
