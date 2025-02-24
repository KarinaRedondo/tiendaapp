package com.tienda.tiendaapp.dtos.gananciaDomiciliario;

import lombok.Data;

@Data

public class ActualizarGananciaDomiciliarioDto {

    private String id;
    private String idDomiciliario;
    private String idPedido;
    private double ganancia;
    private String fechaEntrega;
}
