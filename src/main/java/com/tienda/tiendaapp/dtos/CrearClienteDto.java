package com.tienda.tiendaapp.dtos;

public class CrearClienteDto {

    private String rol;
    private String nombreCompleto;
    private String correo;
    private String password;
    private String telefono;
    private String metodoDePagoPreferido;
    private String direccion;
    private String[] historialDePedidos;

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getMetodoDePagoPreferido() {
        return metodoDePagoPreferido;
    }

    public void setMetodoDePagoPreferido(String metodoDePagoPreferido) {
        this.metodoDePagoPreferido = metodoDePagoPreferido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String[] getHistorialDePedidos() {
        return historialDePedidos;
    }
    public void setHistorialDePedidos(String[] historialDePedidos) {
        this.historialDePedidos = historialDePedidos;
    }
}
