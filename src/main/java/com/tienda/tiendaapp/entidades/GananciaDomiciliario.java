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
    private double gananciaDiaria;
    private double gananciaSemanal;
    private double gananciaMensual;
    private double gananciaAnual;
    private String fechaEntrega;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(String idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public double getGananciaDiaria() {
        return gananciaDiaria;
    }

    public void setGananciaDiaria(double gananciaDiaria) {
        this.gananciaDiaria = gananciaDiaria;
    }

    public double getGananciaSemanal() {
        return gananciaSemanal;
    }

    public void setGananciaSemanal(double gananciaSemanal) {
        this.gananciaSemanal = gananciaSemanal;
    }

    public double getGananciaMensual() {
        return gananciaMensual;
    }

    public void setGananciaMensual(double gananciaMensual) {
        this.gananciaMensual = gananciaMensual;
    }

    public double getGananciaAnual() {
        return gananciaAnual;
    }

    public void setGananciaAnual(double gananciaAnual) {
        this.gananciaAnual = gananciaAnual;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
