package com.tienda.tiendaapp.entidades;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "domiciliarios")

public class Domiciliario extends Usuario{

    private String tipoDeVehiculo;
    private String placaDelVehiculo;
    private int entregasTotales;
    private int calificacionPromedio;
    private int gananciasTotales;
    private boolean estadoDeDisponibilidad;

    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public String getPlacaDelVehiculo() {
        return placaDelVehiculo;
    }

    public void setPlacaDelVehiculo(String placaDelVehiculo) {
        this.placaDelVehiculo = placaDelVehiculo;
    }

    public int getEntregasTotales() {
        return entregasTotales;
    }

    public void setEntregasTotales(int entregasTotales) {
        this.entregasTotales = entregasTotales;
    }

    public int getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(int calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public int getGananciasTotales() {
        return gananciasTotales;
    }

    public void setGananciasTotales(int gananciasTotales) {
        this.gananciasTotales = gananciasTotales;
    }

    public boolean isEstadoDeDisponibilidad() {
        return estadoDeDisponibilidad;
    }

    public void setEstadoDeDisponibilidad(boolean estadoDeDisponibilidad) {
        this.estadoDeDisponibilidad = estadoDeDisponibilidad;
    }
}
