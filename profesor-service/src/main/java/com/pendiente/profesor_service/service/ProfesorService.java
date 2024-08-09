package com.pendiente.profesor_service.service;

import com.pendiente.profesor_service.domain.dto.ProfesorResponse;
import com.pendiente.profesor_service.domain.entity.ProfesorEntity;
import com.pendiente.profesor_service.domain.dto.ProfesorRequest;
import com.pendiente.profesor_service.repository.IProfesorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfesorService {

    private final IProfesorRepository repository;

    public ProfesorResponse guardarProfesor(ProfesorRequest profesor){

        if(repository.existsByDni(profesor.getDni())){
            throw new RuntimeException("Profesor ya existente");
        }
        ProfesorEntity profesorEntity = responseToEntity(profesor);
        profesorEntity = repository.save(profesorEntity);
        return entityToResponse(profesorEntity);
    }

    public ProfesorResponse eliminarProfesor(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Profesor no encontrado");
        }
        ProfesorEntity p = repository.findById(id).get();
        repository.delete(p);
        return entityToResponse(p);
    }
    //TODO: IMPLEMENTAR CONSULTA DINAMICA
    public List<ProfesorResponse> getAllProfesor() {
        List<ProfesorEntity> profesores = repository.findAll();
        return profesores.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    public ProfesorResponse editarProfesor(ProfesorRequest profesor){
        if (!repository.existsByDni(profesor.getDni())){
            throw new RuntimeException("Profesor no existe");
        }
        ProfesorEntity p = repository.getProfesorEntitiesByDni(profesor.getDni()).get();
        p.setNombre(profesor.getNombre());
        p.setEmail(profesor.getEmail());
        p.setTelefono(profesor.getTelefono());
        p.setDireccion(profesor.getDireccion());
        p.setLocalidad(profesor.getLocalidad());
        p.setFechaNacimiento(profesor.getFechaNacimiento());
        ProfesorEntity updatedProfesor = repository.save(p);
        return entityToResponse(updatedProfesor);
    }

    public ProfesorResponse buscarProfesorPorDNI(String dni){
        Optional<ProfesorEntity> profesor = repository.getProfesorEntitiesByDni(dni);
        if(profesor.isEmpty()){
            throw new RuntimeException("Profesor no encontrado");
        }
        ProfesorEntity p = profesor.get();
        return entityToResponse(p);
    }

    private ProfesorEntity responseToEntity(ProfesorRequest profesor) {
        ProfesorEntity profesorEntity = ProfesorEntity.builder()
                .dni(profesor.getDni())
                .nombre(profesor.getNombre())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                .direccion(profesor.getDireccion())
                .localidad(profesor.getLocalidad())
                .fechaNacimiento(profesor.getFechaNacimiento())
                .build();
        return profesorEntity;
    }
    private ProfesorResponse entityToResponse(ProfesorEntity profesorEntity) {
        ProfesorResponse profesorResponse = ProfesorResponse.builder()
                .id(profesorEntity.getId())
                .dni(profesorEntity.getDni())
                .nombre(profesorEntity.getNombre())
                .email(profesorEntity.getEmail())
                .telefono(profesorEntity.getTelefono())
                .direccion(profesorEntity.getDireccion())
                .localidad(profesorEntity.getLocalidad())
                .fechaNacimiento(profesorEntity.getFechaNacimiento())
                .build();
        return profesorResponse;
    }

}
