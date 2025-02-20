package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class ActualizarClienteDto {

    private String id;
    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String idCliente;
    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;
}
