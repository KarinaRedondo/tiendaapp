package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "calificaciones")

public class Calificacion {

    @Id
    private String idCalificacion;
    private String calificacionDomiciliario;
    private String calificacionProducto;
    private String calificacionPedido;
}
