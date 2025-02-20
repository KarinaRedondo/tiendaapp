package com.tienda.tiendaapp.dtos;

import lombok.Data;

@Data

public class CrearTenderoDto {

    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String nombreDeLaTienda;
    private String direccionTienda;
    private String telefonoTienda;
    private String[] historialPedidosAtendidos;

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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreDeLaTienda() {
        return nombreDeLaTienda;
    }

    public void setNombreDeLaTienda(String nombreDeLaTienda) {
        this.nombreDeLaTienda = nombreDeLaTienda;
    }

    public String getDireccionTienda() {
        return direccionTienda;
    }

    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    public String getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(String telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    public String[] getHistorialPedidosAtendidos() {
        return historialPedidosAtendidos;
    }

    public void setHistorialPedidosAtendidos(String[] historialPedidosAtendidos) {
        this.historialPedidosAtendidos = historialPedidosAtendidos;
    }
}
