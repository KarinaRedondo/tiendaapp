package com.tienda.tiendaapp.dtos;
import lombok.Data;
import java.util.List;

@Data

public class CrearInventarioDto {

    private String tendero;
    private List<String> categorias;
    private List<String> productos;
    private String fechaActualizacion;
}
