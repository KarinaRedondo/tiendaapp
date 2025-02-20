package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class CrearDomiciliarioDto {

    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String tipoDeVehiculo;
    private String placaDelVehiculo;
    private int entregasTotales;
    private int calificacionPromedio;
    private int gananciasTotales;
    private boolean estadoDeDisponibilidad;

    public String getRol() {
        return rol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

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
