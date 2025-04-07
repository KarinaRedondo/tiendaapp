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

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
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
}
