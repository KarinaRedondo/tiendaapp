package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class CrearDomiciliarioDto {

    private String tipoDeVehiculo;
    private String placaDelVehiculo;
    private int entregasTotales;
    private int calificacionPromedio;
    private int gananciasTotales;
    private boolean estadoDeDisponibilidad;
}
