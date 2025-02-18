package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class CrearTenderoDto {

    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;
}
