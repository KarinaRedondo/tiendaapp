package com.tienda.tiendaapp.dtos.tienda;

import lombok.Data;

@Data

public class CrearTiendaDto {

    private String nombre;
    private String direccion;
    private String telefono;
    private String idTendero;
    private String catalogoBasico;
    private double totalVentas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdTendero() {
        return idTendero;
    }

    public void setIdTendero(String idTendero) {
        this.idTendero = idTendero;
    }

    public String getCatalogoBasico() {
        return catalogoBasico;
    }

    public void setCatalogoBasico(String catalogoBasico) {
        this.catalogoBasico = catalogoBasico;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
}
