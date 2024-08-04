package com.pendiente.profesor_service.controller;

import com.pendiente.profesor_service.dto.ProfesorDTO;
import com.pendiente.profesor_service.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores") // Cambiado a "/api/profesores"
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService service;

    @PostMapping("/save")
    public ResponseEntity<?> crearProfesor(@RequestBody ProfesorDTO profesorDTO) {
        return new ResponseEntity<>(service.guardarProfesor(profesorDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> buscarProfesorPorDni(@RequestParam String dni){
        return new ResponseEntity<>(service.buscarProfesorPorDNI(dni), HttpStatus.OK);
    }

}
