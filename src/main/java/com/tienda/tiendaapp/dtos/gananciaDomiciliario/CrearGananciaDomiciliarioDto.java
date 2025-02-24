package com.tienda.tiendaapp.dtos.gananciaDomiciliario;

import lombok.Data;

@Data

public class CrearGananciaDomiciliarioDto {

    private String idDomiciliario;
    private String idPedido;
    private double ganancia;
    private String fechaEntrega;
}
