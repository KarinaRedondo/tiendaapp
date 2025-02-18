package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tenderos")

public class Tendero extends Usuario {

    @Id
    private String idTendero;
    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;
}
