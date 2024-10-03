package com.pendiente.materia_service.service;

import com.pendiente.materia_service.fecade.IMateriaFecade;
import com.pendiente.materia_service.model.dto.ActualizarMateriaDto;
import com.pendiente.materia_service.model.dto.AsignarProfesorDto;
import com.pendiente.materia_service.model.dto.MateriaDto;
import com.pendiente.materia_service.model.entities.Materia;
import com.pendiente.materia_service.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MateriaService {

    //TODO: eliminar profesor de materia, eliminar materia

    private final MateriaRepository repository;
    private final IMateriaFecade materiaFecade;

    public Materia guardarMateria(MateriaDto materia) {
        Materia mat = Materia.builder()
                .nombre(materia.getNombre())
                .build();
        log.info("Guardando materia");
        return repository.save(mat);
    }
    public Materia updateMateria(ActualizarMateriaDto request){
       UUID id = request.getIdMateria();
       if(!repository.existsById(id)){
           throw new RuntimeException("La materia a actualizar no existe por id");
       }
       Materia materiaUpdate = repository.findById(id).orElseThrow();
       materiaUpdate.setNombre(request.getNombre());
       return repository.save(materiaUpdate);
    }
    public Materia asignarProfesor(AsignarProfesorDto request) {
        UUID id = request.getIdMateria();
        if(!repository.existsById(id)){
            throw new RuntimeException("La materia a la que se quiere asignar un profesor no existe por id");
        }
        materiaFecade.verificarExistenciaProfesor(request.getIdProfesor());
        Materia materia = repository.findById(id).orElseThrow();
        materia.getProfesoresIds().add(request.getIdProfesor());
        return repository.save(materia);
    }
    public List<Materia> obtenerTodasLasMaterias() {
        return repository.findAll();
    }

    public Materia desafectarProfesor(AsignarProfesorDto asignarProfesorDto) {
       Optional<Materia> materia ;
        materia = repository.findById(asignarProfesorDto.getIdMateria());
        if(!materia.isPresent()) {
            throw new RuntimeException("Materia inexistente");
        }
        materia.get().getProfesoresIds().remove(asignarProfesorDto.getIdProfesor());
        return repository.save(materia.get());
    }

    public void eliminarMateria(UUID materiaId){
        if (!repository.existsById(materiaId)){
            throw new RuntimeException("Materia no existe en base de datos : " + materiaId);
        }
        Materia materia = repository.getById(materiaId);
        if(materia.getProfesoresIds().size() > 0){
            throw new RuntimeException("No se puede eliminar una materia que tiene profesores asociados");
        }
        repository.deleteById(materiaId);
    }

    public Materia buscarMatetriaPorId(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("La materia no existe"));
    }
}
