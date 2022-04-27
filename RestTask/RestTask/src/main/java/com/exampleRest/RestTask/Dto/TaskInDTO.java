package com.exampleRest.RestTask.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class TaskInDTO
{

    private String titulo;
    private String descripcion;
    private LocalDate fet;
}
