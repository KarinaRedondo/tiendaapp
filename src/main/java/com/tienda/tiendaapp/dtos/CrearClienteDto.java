package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class CrearClienteDto {

    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;
}
