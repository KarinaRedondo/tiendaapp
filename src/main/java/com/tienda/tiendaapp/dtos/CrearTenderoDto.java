package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class CrearTenderoDto {

    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;
}
