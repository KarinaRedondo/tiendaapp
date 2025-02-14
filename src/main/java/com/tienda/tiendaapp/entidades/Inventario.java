package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventarios")

public class Inventario {

    @Id
    private String idInventario;
    private String tendero;
    private String[] categorias;
    private String[] productos;
    private String fechaActualizacion;
}
