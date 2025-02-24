package com.tienda.tiendaapp.dtos.historialVenta;

import lombok.Data;

@Data

public class ActualizarHistorialventaDto {

    private String id;
    private String idTienda;
    private String fecha;
    private double ventasDiarias;
    private double ventasSemanales;
    private double ventasMensuales;
}
