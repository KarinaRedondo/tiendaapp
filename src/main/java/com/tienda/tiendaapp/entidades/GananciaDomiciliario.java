package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "gananciasDomicilirio")

public class GananciaDomiciliario {

    @Id
    private String id;
    private String idDomiciliario;
    private String idPedido;
    private double ganancia;
    private String fechaEntrega;
}
