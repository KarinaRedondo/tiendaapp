package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tiendas")

public class Tienda {

    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String idTendero;
    private String catalogoBasico;
    private double totalVentas;
}
