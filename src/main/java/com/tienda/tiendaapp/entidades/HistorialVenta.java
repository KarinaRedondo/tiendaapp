package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "historialVentas")

public class HistorialVenta {

    @Id
    private String id;
    private String idTienda;
    private String fecha;
    private double ventasDiarias;
    private double ventasSemanales;
    private double ventasMensuales;
}
