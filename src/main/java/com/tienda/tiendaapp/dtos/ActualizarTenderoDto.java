package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class ActualizarTenderoDto {

    private String idTendero;
    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;
}
