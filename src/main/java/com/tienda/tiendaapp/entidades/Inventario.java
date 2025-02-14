package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "inventarios")

public class Inventario {

    @Id
    private String idInventario;
    private String tendero;
    private List<String> categorias;
    private List<String> productos;
    private String fechaActualizacion;
}
