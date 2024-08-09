package com.pendiente.alumnoservice.controller;

import com.pendiente.alumnoservice.entity.dto.AlumnoRequest;
import com.pendiente.alumnoservice.service.AlumnoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService service;

    @PostMapping("/save")
    public ResponseEntity<?> crearAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        return new ResponseEntity<>(service.saveAlumno(alumnoRequest), HttpStatus.CREATED);
    }
    //TODO: IMPLEMENTAR CONSULTA DINAMICA
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlumnoId(@PathVariable Long id){
        return new ResponseEntity<>(service.getAlumnoById(id), HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<?> actualizarAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        return new ResponseEntity<>(service.editarAlumno(alumnoRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> listarAlumnos(){
        return new ResponseEntity<>(service.getAllAlumnos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long id){
        return new ResponseEntity<>(service.eliminarAlumno(id), HttpStatus.OK);
    }
}
