package com.tienda.tiendaapp.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tiendas")

public class Tienda {

    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String idTendero;
    private String catalogoBasico;
    private double totalVentas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
