package com.tienda.tiendaapp.dtos.ganancias;

import lombok.Data;

@Data
public class GananciasResponseDTO {
    private double semanales;
    private double mensuales;
    private double anuales;

    public GananciasResponseDTO(double diarias, double semanales, double mensuales) {
        this.semanales = semanales;
        this.mensuales = mensuales;
        this.anuales = anuales;
    }
}
