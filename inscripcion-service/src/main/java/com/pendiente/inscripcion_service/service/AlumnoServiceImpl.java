package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.AlumnoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AlumnoServiceImpl implements AlumnoService{

    private final WebClient.Builder webClientBuilder;
    @Override
    public AlumnoDTO verificarAlumno(Long id) {
        log.info("Llamando al microservicoo Alumno para verificar id" + id);
        AlumnoDTO dto = this.webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/alumnos/{id}", id)
                .retrieve()
                .bodyToMono(AlumnoDTO.class)
                .block();
        if(dto == null || dto.equals("")){
            throw new RuntimeException("No se encontraron alumnos o la respuesta del microservicio esta vacia " );
        }
        return dto;
    }
}
