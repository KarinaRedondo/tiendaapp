package com.tienda.tiendaapp.dtos.tienda;

import lombok.Data;

@Data

public class ActualizarTiendaDto {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String idTendero;
    private String catalogoBasico;
    private double totalVentas;
}
