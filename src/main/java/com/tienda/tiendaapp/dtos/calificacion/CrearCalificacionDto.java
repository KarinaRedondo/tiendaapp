package com.tienda.tiendaapp.dtos.calificacion;

import lombok.Data;

@Data

public class CrearCalificacionDto {

    private String idpedido;
    private String idCliente;
    private String idTienda;
    private int calificacionTienda;
    private String comentarioTienda;
    private String respuestaTendero;
    private String idDomiciliario;
    private int calificacionDomiciliario;
    private String comentarioDomiciliario;
    private String respuestaDomiciliario;
}
