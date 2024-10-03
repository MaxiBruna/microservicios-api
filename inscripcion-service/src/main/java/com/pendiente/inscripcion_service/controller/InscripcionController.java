package com.pendiente.inscripcion_service.controller;

import com.pendiente.inscripcion_service.dto.InscripcionDTO;
import com.pendiente.inscripcion_service.entity.Inscripcion;
import com.pendiente.inscripcion_service.service.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {
    private final InscripcionService inscripcionService;

    @PostMapping("/")
    public ResponseEntity<?> crearInscripción(@RequestBody InscripcionDTO inscripcionDTO){
        return new ResponseEntity<>(this.inscripcionService.crearInscripcion(inscripcionDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Inscripcion encontrarMateriaPorId(@PathVariable UUID id){
        return inscripcionService.encontrarPorId(id);
    }



}
