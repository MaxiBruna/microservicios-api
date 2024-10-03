package com.pendiente.inscripcion_service.service;

import com.pendiente.inscripcion_service.dto.MateriaDTO;
import com.pendiente.inscripcion_service.dto.ProfesorDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProfesorServiceImpl implements ProfesorService{

    private final WebClient.Builder webClientBuilder;
    @Override
    public ProfesorDTO verificarProfesor(Long id) {
        log.info("Llamando al microservicoo Profesor para verificar id" + id);
        ProfesorDTO dto = this.webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/api/profesores/profesorPorId/{id}", id)
                .retrieve()
                .bodyToMono(ProfesorDTO.class)
                .block();
        if(dto == null || dto.equals("")){
            throw new RuntimeException("No se encontraron profesores o la respuesta del microservicio esta vacia " );
        }
        return dto;
    }
}
