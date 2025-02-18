package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class ActualizarPedidoDto {

    private String idPedido;
    private String tendero;
    private String observaciones;
    private String descripcionCliente;
    private boolean aceptacionCliente;
    private String fecha;
    private String hora;
    private String estado;
    private int montoTotal;
    private String metodoPago;
    private String direccionEntrega;
    private String cliente;
    private String domiciliario;
}
