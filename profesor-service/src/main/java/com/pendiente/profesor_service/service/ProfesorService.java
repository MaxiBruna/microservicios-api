package com.pendiente.profesor_service.service;

import com.pendiente.profesor_service.domain.ProfesorEntity;
import com.pendiente.profesor_service.dto.ProfesorDTO;
import com.pendiente.profesor_service.repository.IProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final IProfesorRepository repository;

    public ProfesorEntity guardarProfesor(ProfesorDTO profesor){
        var profesorExists = repository.searchByDni(profesor.getDni());
        if(profesorExists != null){
            throw new RuntimeException(profesor.getDni() + " ya registrado");
        }
        ProfesorEntity profesorEntity = dtoToProfesor(profesor);
        return repository.save(profesorEntity);
    }

    public ProfesorEntity buscarProfesorPorDNI(String dni){
        var profesor = repository.getProfesorEntitiesByDni(dni);
        if(profesor == null){
            throw new RuntimeException("Profesor no encontrado");
        }
        return profesor;
    }



    private ProfesorEntity dtoToProfesor(ProfesorDTO profesor) {
        ProfesorEntity profesorEntity = ProfesorEntity.builder()
                .dni(profesor.getDni())
                .nombre(profesor.getNombre())
                .email(profesor.getEmail())
                .telefono(profesor.getTelefono())
                .direccion(profesor.getDireccion())
                .numeroDomicilio(profesor.getNumeroDomicilio())
                .fechaNacimiento(profesor.getFechaNacimiento())
                .build();
        return profesorEntity;
    }
}
