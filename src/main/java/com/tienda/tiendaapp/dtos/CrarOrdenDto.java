package com.tienda.tiendaapp.dtos;
import lombok.Data;

import java.util.List;

@Data

public class CrarOrdenDto {

    private String fecha;
    private String hora;
    private String estado;
    private int montoTotal;
    private String metodoPago;
    private String direccionEntrega;
    private String cliente;
    private String domiciliario;
    private List<String> productos;
}
