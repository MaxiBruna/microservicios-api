package com.pendiente.materia_service.fecade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;


@Component
@RequiredArgsConstructor
@Slf4j
public class MateriaFecadeImpl implements IMateriaFecade{

    private final WebClient.Builder webClient;

    @Override
    public Long verificarExistenciaProfesor(Long id) {
        log.warn("Llamando al microservicoo profesores");
        String profesor = this.webClient.build()
                 .get()
                 .uri("http://localhost:8083/api/profesores/profesorPorId?id=" + id)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();
        if(profesor == null || profesor.equals("")) {
           throw new RuntimeException ("No se encontraron profesores o la respuesta del microservicio esta vacia " );
        }
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(profesor);
            Long profesorId = node.path("id").asLong();
            log.info("Retornando respuesta " );
            return  profesorId;
        }catch(JsonProcessingException e){
            throw new RuntimeException("Error al procesar la respuesta del microservicio de profesores", e);
        }
    }
}
