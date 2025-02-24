package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vehiculos")

public class Vehiculo {

    @Id
    private String id;
    private String idDomiciliario;
    private String tipo;
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCarga;
}
