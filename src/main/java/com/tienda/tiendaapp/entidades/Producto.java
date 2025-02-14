package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "productos")

public class Producto {

    @Id
    private String idProducto;
    private String nombre;
    private String descripcion;
    private String[] categoria;
    private int precio;
    private int stock;
    private String inventario;
}
