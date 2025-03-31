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
    private double ventasAnuales;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getVentasDiarias() {
        return ventasDiarias;
    }

    public void setVentasDiarias(double ventasDiarias) {
        this.ventasDiarias = ventasDiarias;
    }

    public double getVentasSemanales() {
        return ventasSemanales;
    }

    public void setVentasSemanales(double ventasSemanales) {
        this.ventasSemanales = ventasSemanales;
    }

    public double getVentasMensuales() {
        return ventasMensuales;
    }

    public void setVentasMensuales(double ventasMensuales) {
        this.ventasMensuales = ventasMensuales;
    }

    public double getVentasAnuales() {
        return ventasAnuales;
    }

    public void setVentasAnuales(double ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }
}
