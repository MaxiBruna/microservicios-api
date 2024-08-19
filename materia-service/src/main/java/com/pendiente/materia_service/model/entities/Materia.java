package com.pendiente.materia_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    @ElementCollection
    @CollectionTable(name = "profesores_materia", joinColumns = @JoinColumn(name = "materia_id"))
    @Column(name = "id_profesor")
    private List<Long> profesoresIds;

}
