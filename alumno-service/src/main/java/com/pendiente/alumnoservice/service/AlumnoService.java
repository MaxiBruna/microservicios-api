package com.pendiente.alumnoservice.service;

import com.pendiente.alumnoservice.entity.Alumno;
import com.pendiente.alumnoservice.entity.dto.AlumnoRequest;
import com.pendiente.alumnoservice.entity.dto.AlumnoResponse;
import com.pendiente.alumnoservice.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repository;

    public AlumnoResponse getAlumnoById(Long id) {
        if(!repository.existsAlumnosById(id)){
            throw new RuntimeException("El alumno no existe en la base de datos");
        };
        Alumno p = repository.findAlumnoById(id).get();
        return entityToResponse(p);
    }
    //TODO: IMPLEMENTAR CONSULTA DINAMICA
    public AlumnoResponse saveAlumno(AlumnoRequest alumno) {
        if(repository.existsAlumnosById(alumno.getId())){
            throw new RuntimeException("El alumno ya existe en la base de datos");
        }
        Alumno a = requestToEntity(alumno);
        Alumno savedAlumno = repository.save(a);
        return entityToResponse(savedAlumno);
    }
    public AlumnoResponse eliminarAlumno(Long id){
        if(!repository.existsAlumnosById(id)){
            throw new RuntimeException("El alumno no existe en la base de datos");
        }
        Alumno a = repository.findAlumnoById(id).get();
        repository.delete(a);
        return entityToResponse(a);
    }

    public AlumnoResponse editarAlumno(AlumnoRequest alumnoRequest){
        if(!repository.existsAlumnosById(alumnoRequest.getId())){
            throw new RuntimeException("El alumno no existe en la base de datos");
        }

        Alumno a = repository.findAlumnoById(alumnoRequest.getId()).get();
        a.setNombre(alumnoRequest.getNombre());
        a.setEmail(alumnoRequest.getEmail());
        Alumno updatedAlumno = repository.save(a);
        return entityToResponse(updatedAlumno);
    }

    public List<AlumnoResponse> getAllAlumnos() {
        List<Alumno> profesores = repository.findAll();
        return profesores.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    private Alumno requestToEntity(AlumnoRequest alumno) {
        Alumno a = Alumno.builder()
                .id(alumno.getId())
                .nombre(alumno.getNombre())
                .email(alumno.getEmail())
                .build();
        return a;
    }

    private AlumnoResponse entityToResponse(Alumno p) {
        return AlumnoResponse.builder()
                .nombre(p.getNombre())
                .email(p.getEmail())
                .id(p.getId())
                .build();
    }
}
