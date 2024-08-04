package com.pendiente.profesor_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "profesores")
@Entity
public class ProfesorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(name = "dni", unique = true)
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    @Column(name = "numeracion_domicilio")
    private String numeroDomicilio;
    private String localidad;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;



}
