package com.pendiente.profesor_service.controller;

import com.pendiente.profesor_service.domain.dto.ProfesorRequest;
import com.pendiente.profesor_service.domain.dto.ProfesorResponse;
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
    public ResponseEntity<?> crearProfesor(@RequestBody ProfesorRequest profesorRequest) {
        return new ResponseEntity<>(service.guardarProfesor(profesorRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> buscarProfesorPorDni(@RequestParam String dni){
        return new ResponseEntity<>(service.buscarProfesorPorDNI(dni), HttpStatus.OK);
    }
    @GetMapping("/profesorPorId")
    public ProfesorResponse getBuscarProfesorPorDni(@RequestParam Long id){
        return service.buscarProfesorPorID(id);
    }
//TODO: IMPLEMENTAR CONSULTA DINAMICA
    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Long id, @RequestBody ProfesorRequest profesorRequest) {
        return new ResponseEntity<>(service.editarProfesor(profesorRequest , id), HttpStatus.ACCEPTED);
    }
    //TODO: IMPLEMENTAR BOOLEAN EXIST PARA API MATERIA ("/{id}/existsProfesorById")

    @GetMapping("/all")
    public ResponseEntity<?> buscarTodosLosProfesores(){
        return new ResponseEntity<>(service.getAllProfesor(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long id){
        return new ResponseEntity<>(service.eliminarProfesor(id), HttpStatus.OK);
    }

}
