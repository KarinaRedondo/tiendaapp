package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "gananciasTienda")
public class GananciaTienda {
    @Id
    private String id;
    private String idTienda;
    private String idPedido;
    private double monto;
    private String fechaVenta;
    private double gananciaDiaria;
    private double gananciaSemanal;
    private double gananciaMensual;
    private double gananciaAnual;
}
