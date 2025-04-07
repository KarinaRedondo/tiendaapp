package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "gananciasDomiciliario")

public class GananciaDomiciliario {

    @Id
    private String id;
    private String idDomiciliario;
    private String idPedido;
    private double monto;
    private double gananciaDiaria;
    private double gananciaSemanal;
    private double gananciaMensual;
    private double gananciaAnual;
    private String fechaEntrega;
}
