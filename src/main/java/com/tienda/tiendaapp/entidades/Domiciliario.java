package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "domiciliarios")

public class Domiciliario extends Usuario{

    @Id
    private String idDomiciliario;
    private String tipoDeVehiculo;
    private String placaDelVehiculo;
    private int entregasTotales;
    private int calificacionPromedio;
    private int gananciasTotales;
    private boolean estadoDeDisponibilidad;
}
