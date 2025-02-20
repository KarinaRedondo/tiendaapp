package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class ActualizarDomiciliarioDto {

    private String id;
    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String tipoDeVehiculo;
    private String placaDelVehiculo;
    private int entregasTotales;
    private int calificacionPromedio;
    private int gananciasTotales;
    private boolean estadoDeDisponibilidad;
}
