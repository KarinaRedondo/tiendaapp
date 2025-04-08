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
    private double monto;
    private String fechaVenta;

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
}
