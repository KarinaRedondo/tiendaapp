package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class CrearCalificacionDto {

    private int calificacionDomiciliario;
    private int calificacionPedido;
    private String comentarios;
    private String fecha;
}
