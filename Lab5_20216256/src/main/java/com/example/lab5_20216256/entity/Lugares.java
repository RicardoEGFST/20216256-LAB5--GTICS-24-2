package com.example.lab5_20216256.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lugares")
public class Lugares {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idLugares",nullable = false)
    private Integer idLugares;

    @Column(name = "nombre_lugar", length = 45)
    private String nombreLugar;

    @Column(name = "descrip_lugar", length = 45)
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private Date fechaLugar;

    @OneToMany(mappedBy = "Idlugares")
    private List<Viajes> viajes;
}
