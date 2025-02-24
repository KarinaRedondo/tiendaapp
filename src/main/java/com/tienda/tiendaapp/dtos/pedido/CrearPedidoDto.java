package com.tienda.tiendaapp.dtos.pedido;

import lombok.Data;

@Data

public class CrearPedidoDto {

    private String idCliente;
    private String idTienda;
    private String descripcionPedido;
    private double montoTotal;
    private double precioDomicilio;
    private String estado;
    private String idDomiciliario;
    private String gananciaDomiciliario;
    private String comentariosTendero;
    private String fechaCreacion;
    private String fechaExpiracion;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getPrecioDomicilio() {
        return precioDomicilio;
    }

    public void setPrecioDomicilio(double precioDomicilio) {
        this.precioDomicilio = precioDomicilio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(String idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public String getGananciaDomiciliario() {
        return gananciaDomiciliario;
    }

    public void setGananciaDomiciliario(String gananciaDomiciliario) {
        this.gananciaDomiciliario = gananciaDomiciliario;
    }

    public String getComentariosTendero() {
        return comentariosTendero;
    }

    public void setComentariosTendero(String comentariosTendero) {
        this.comentariosTendero = comentariosTendero;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
