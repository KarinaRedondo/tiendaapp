package com.tienda.tiendaapp.dtos;
import lombok.Data;

import java.util.List;

@Data

public class ActualizarProductoDto {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private List<String> categoria;
    private int precio;
    private int stock;
    private String inventario;
}
