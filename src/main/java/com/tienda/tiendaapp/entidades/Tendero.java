package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tenderos")

public class Tendero {

    @Id
    private String idTendero;
    private String inventario;
    private String nombreDeLaTienda;
}
