package com.tienda.tiendaapp.dtos.vehiculo;

import lombok.Data;

@Data

public class CrearVehiculoDto {

    private String idDomiciliario;
    private String tipo;
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCarga;
}
