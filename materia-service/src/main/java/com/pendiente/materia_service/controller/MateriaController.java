package com.pendiente.materia_service.controller;

import com.pendiente.materia_service.model.dto.ActualizarMateriaDto;
import com.pendiente.materia_service.model.dto.AsignarProfesorDto;
import com.pendiente.materia_service.model.dto.MateriaDto;
import com.pendiente.materia_service.service.MateriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService service;

    @PostMapping("/")
    public ResponseEntity<?> crearMateria(@RequestBody MateriaDto materiaDto) {

        return new ResponseEntity<>(service.guardarMateria(materiaDto),HttpStatus.CREATED);

    }

    @PostMapping("/asignarProfesor")
    public ResponseEntity<?> asignarProfesor(@RequestBody AsignarProfesorDto request) {
        return new ResponseEntity<>(service.asignarProfesor(request), HttpStatus.ACCEPTED);
    }
    @GetMapping("/allMaterias")
    public ResponseEntity<?> listarMaterias(){
        return new ResponseEntity<>(service.obtenerTodasLasMaterias(), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarMateria(@RequestBody ActualizarMateriaDto request) {
        return new ResponseEntity<>(service.updateMateria(request), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/desafectarProfesor")
    public ResponseEntity<?> deleteDesafectarProfesor(@RequestBody AsignarProfesorDto request){
        return new ResponseEntity<>(service.desafectarProfesor(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getMateriaById(@PathVariable UUID id){
        service.eliminarMateria(id);
        log.info("Eliminando materia");
        return new ResponseEntity<>("Materia eliminada", HttpStatus.OK);
    }
}
