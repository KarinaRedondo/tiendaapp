package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class ActualizarCalificacionDto {

    private String idCalificacion;
    private int calificacionDomiciliario;
    private int calificacionProducto;
    private int calificacionPedido;
}
