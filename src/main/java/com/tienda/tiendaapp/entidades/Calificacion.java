package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "calificaciones")

public class Calificacion {

    @Id
    private String id;
    private String idpedido;
    private String idCliente;
    private String idTienda;
    private int calificacionTienda;
    private String comentarioTienda;
    private String respuestaTendero;
    private String idDomiciliario;
    private int calificacionDomiciliario;
    private String comentarioDomiciliario;
    private String respuestaDomiciliario;
}
