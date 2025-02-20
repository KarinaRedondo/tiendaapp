package com.tienda.tiendaapp.dtos;
import lombok.Data;

@Data

public class CrearPedidoDto {

    private String tendero;
    private String observaciones;
    private String descripcionCliente;
    private boolean aceptacionCliente;
    private String fecha;
    private String hora;
    private String estado;
    private int montoTotal;
    private String metodoPago;
    private String direccionEntrega;
    private String cliente;
    private String domiciliario;

    public String getTendero() {
        return tendero;
    }

    public void setTendero(String tendero) {
        this.tendero = tendero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    public boolean isAceptacionCliente() {
        return aceptacionCliente;
    }

    public void setAceptacionCliente(boolean aceptacionCliente) {
        this.aceptacionCliente = aceptacionCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(String domiciliario) {
        this.domiciliario = domiciliario;
    }
}
