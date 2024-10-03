package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.MateriaDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MateriaServiceImpl implements MateriaService{

    private final WebClient.Builder webClientBuilder;
    @Override
    public MateriaDTO verificarMateria(UUID id) {
        log.info("Llamando al microservicoo Alumno para verificar id" + id);
        MateriaDTO dto = this.webClientBuilder.build()
                .get()
                .uri("http://localhost:8084/api/materias/{id}", id)
                .retrieve()
                .bodyToMono(MateriaDTO.class)
                .block();
        if(dto == null || dto.equals("")){
            throw new RuntimeException("No se encontraron alumnos o la respuesta del microservicio esta vacia " );
        }
        if(dto.getProfesoresIds().isEmpty()){ // Cambiar 'getIdProfesor()' por 'getProfesoresIds()'
            throw new RuntimeException("La materia no tiene profesor asociado");
        }
        return dto;
    }
}
