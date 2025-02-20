package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class ActualizarCalificacionDto {

    private String idCalificacion;
    private int calificacionDomiciliario;
    private int calificacionPedido;
    private String comentarios;
    private String fecha;
}
