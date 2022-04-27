package com.exampleRest.RestTask.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate createdDate;
    private LocalDate fet;
    private boolean finished;
    private boolean estado;
}
