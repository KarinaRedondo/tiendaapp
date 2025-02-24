package com.tienda.tiendaapp.dtos.pedido;

import lombok.Data;

@Data

public class ActualizarPedidoDto {

    private String id;
    private String idCliente;
    private String idTienda;
    private String descripcionPedido;
    private int montoTotal;
    private int precioDomicilio;
    private String estado;
    private String idDomiciliario;
    private String gananciaDomiciliario;
    private String comentariosTendero;
    private String fechaCreacion;
    private String fechaExpiracion;
}
