package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class ActualizarClienteDto {

    private String idCliente;
    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;
}
